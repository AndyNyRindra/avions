package cloud.avions.repository;

import cloud.avions.model.Kilometrage;
import cloud.avions.model.Avion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KilometrageRepository extends JpaRepository<Kilometrage, Long> {

    List<Kilometrage> findAllByAvion(Avion avion);
}
