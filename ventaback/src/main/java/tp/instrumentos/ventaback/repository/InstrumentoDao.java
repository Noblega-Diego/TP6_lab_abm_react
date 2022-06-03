package tp.instrumentos.ventaback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tp.instrumentos.ventaback.entitys.Instrumento;

@Repository
public interface InstrumentoDao extends JpaRepository<Instrumento, Long> {
}
