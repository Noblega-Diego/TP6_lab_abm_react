package tp.instrumentos.ventaback.entitys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "instrumentos")
@Builder
@AllArgsConstructor
public class Instrumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "instrumento", nullable = false)
    private String instrumento;
    @Column(name = "descripcion", nullable = false, length = 1024)
    private String descripcion;
    @Column(name = "marca", nullable = false)
    private String marca;
    @Column(name = "modelo", nullable = false)
    private String modelo;
    @Column(name = "precio", nullable = false)
    private Double precio;
    @Column(name = "costoEnvio", nullable = false)
    private Double costoEnvio;
    @Column(name = "cantidadVendida", nullable = false)
    private Integer cantidadVendida;
    @Column(name = "urlImage", nullable = false)
    private String urlImage;
    public Instrumento() {

    }
}
