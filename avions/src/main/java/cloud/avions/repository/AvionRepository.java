package cloud.avions.repository;

import cloud.avions.model.Avion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AvionRepository extends JpaRepository<Avion, Long> {
}
