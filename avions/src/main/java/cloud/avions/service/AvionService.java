package cloud.avions.service;

import cloud.avions.model.Avion;

import java.util.List;

public interface AvionService {
    Avion save(Avion avion);
    List<Avion> getAll();
    Avion getById(long id);
    Avion update(Avion avion, long id);
    void delete(long id);
}

