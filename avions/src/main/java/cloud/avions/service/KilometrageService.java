package cloud.avions.service;

import cloud.avions.model.Kilometrage;
import cloud.avions.model.Avion;

import java.util.List;

public interface KilometrageService {

    Kilometrage saveKilometrage(Kilometrage kilometrage);
    List<Kilometrage> getAllByAvion(Avion avion);
    Kilometrage getKilometrageById(long id);
    Kilometrage updateKilometrage(Kilometrage kilometrage, long id);
    void deleteKilometrage(long id);
}
