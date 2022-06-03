package tp.instrumentos.ventaback.controllers;

import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tp.instrumentos.ventaback.repository.InstrumentoDao;
import tp.instrumentos.ventaback.entitys.Instrumento;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@Controller
public class InstrumentoController {

    private InstrumentoDao instrumentoDao;

    public InstrumentoController(InstrumentoDao instrumentoDao){
        this.instrumentoDao = instrumentoDao;
    }

    @GetMapping("/instrumentos")
    public ResponseEntity<List<InstrumentoDto>> getAll(){
        ArrayList<Instrumento> instrumentos = (ArrayList<Instrumento>) instrumentoDao.findAll();
        ArrayList<InstrumentoDto> instrumentoDtos = (ArrayList<InstrumentoDto>) instrumentos.stream().map((this::convertToInstrumentoDto)).collect(Collectors.toList());
        return ResponseEntity.ok().body(instrumentoDtos);
    }

    private InstrumentoDto convertToInstrumentoDto(Instrumento instrumento) {
        return InstrumentoDto.builder()
                .id(instrumento.getId())
                .instrumento(instrumento.getInstrumento())
                .cantidadVendida(instrumento.getCantidadVendida())
                .precio(instrumento.getPrecio())
                .descripcion(instrumento.getDescripcion())
                .marca(instrumento.getMarca())
                .modelo(instrumento.getModelo())
                .imagen(instrumento.getUrlImage())
                .costoEnvio((instrumento.getCostoEnvio() == 0) ? "G" : instrumento.getCostoEnvio())
                .build();
    }

    @GetMapping("/instrumentos/{Id}")
    public ResponseEntity<InstrumentoDto> getById(@PathVariable(value = "Id") Long id){
        Instrumento instrumento = instrumentoDao.findById(id).orElse(null);
        InstrumentoDto instrumentoDto = convertToInstrumentoDto(instrumento);
        return ResponseEntity.ok().body(instrumentoDto);
    }

    @PostMapping("/instrumentos")
    public ResponseEntity<InstrumentoDto> getById(@RequestBody InstrumentoDto instrumentoDto){
        Instrumento instrumento = covertToInstrumento(instrumentoDto);
        return ResponseEntity.ok().body(convertToInstrumentoDto(instrumentoDao.save(instrumento)));
    }

    @PutMapping("/instrumentos/{Id}")
    public ResponseEntity<InstrumentoDto> getById(@PathVariable(value = "Id") Long id, @RequestBody InstrumentoDto instrumentoDto){
        Instrumento instrumento = covertToInstrumento(instrumentoDto);
        instrumento.setId(id);
        return ResponseEntity.ok().body(convertToInstrumentoDto(instrumentoDao.save(instrumento)));
    }

    @DeleteMapping("/instrumentos/{Id}")
    public ResponseEntity<?> deleteById(@PathVariable(value = "Id") Long id){
        instrumentoDao.deleteById(id);
        return ResponseEntity.status(201).build();
    }

    private Instrumento covertToInstrumento(InstrumentoDto instrumentoDto) {
            Instrumento instrumento = Instrumento.builder()
                    .id(instrumentoDto.getId())
                    .instrumento(instrumentoDto.getInstrumento())
                    .cantidadVendida(instrumentoDto.getCantidadVendida())
                    .precio(instrumentoDto.getPrecio())
                    .descripcion(instrumentoDto.getDescripcion())
                    .marca(instrumentoDto.getMarca())
                    .modelo(instrumentoDto.getModelo())
                    .urlImage(instrumentoDto.getImagen())
                    .build();
        try {
            instrumento.setCostoEnvio(Double.valueOf(String.valueOf(instrumentoDto.getCostoEnvio())));
        }catch (NumberFormatException e){
            if(instrumentoDto.getCostoEnvio().equals("G"))
                instrumento.setCostoEnvio(0.0);
        }
        return instrumento;
    }


    @Builder
    @Data
    public static class InstrumentoDto {
        private Long id;
        private String instrumento;
        private String descripcion;
        private String marca;
        private String modelo;
        private Double precio;
        private Integer cantidadVendida;
        private Object costoEnvio;
        private String imagen;
    }

}
