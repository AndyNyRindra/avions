package cloud.avions.repository;

import cloud.avions.model.Avion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssuranceRepository extends JpaRepository<Avion, Long> {
    // @Query(value = "select vehicule.* from (select *, age(date_expiration ,now())
    // perim from assurance) tab join vehicule on vehicule.id = tab.vehicule_id
    // where perim < :mois ", nativeQuery = true)
    // List<Vehicule> getFinAssurance(@Param(value = "mois") String mois);

    @Query(value = "select avion.* from (select *, age(date_expiration ,now()) perim from assurance) tab join avion on avion.id = tab.avion_id where perim < ?1 * INTERVAL '1 mons' and date_expiration >= now()", nativeQuery = true)
    List<Avion> getFinAssurance(Integer mois);

}