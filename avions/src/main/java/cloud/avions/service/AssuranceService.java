package cloud.avions.service;

import cloud.avions.model.Avion;

import java.util.List;

public interface AssuranceService {

    List<Avion> getAvionFinAss(int mois);
}
