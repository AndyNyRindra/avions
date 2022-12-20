package cloud.avions.serviceImpl;

import cloud.avions.exception.ResourceNotFoundException;
import cloud.avions.model.Avion;
import cloud.avions.repository.AvionRepository;
import cloud.avions.service.AvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvionServiceImpl implements AvionService {

    @Autowired
    private AvionRepository avionRepository;

    @Override
    public Avion save(Avion avion) {
        return avionRepository.save(avion);
    }

    @Override
    public List<Avion> getAll() {
        return avionRepository.findAll();
    }

//    @Override
//    public Vehicule getVehiculeById(long id) {
//        /* Optional<Vehicule> vehicule = vehiculeRepository.findById(id);
//        if (vehicule.isPresent()) {
//            return vehicule.get();
//        } else {
//            throw new ResourceNotFoundException("Vehicule", "id", id);
//        } */
//
//        return vehiculeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehicule", "id", id));
//    }

    @Override
    public Avion getById(long id) {
        Avion vehicule = avionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehicule", "id", id));
        return vehicule;
    }

    @Override
    public Avion update(Avion avion, long id) {
        /*return vehiculeRepository.findById(id).map(v -> {
            v.setMatricule(vehicule.getMatricule());
            return vehiculeRepository.save(v);
        }).orElseThrow(() -> new ResourceNotFoundException("Vehicule", "id", id));*/

        Avion existingAvion = avionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehicule", "id", id));
        existingAvion.setMatricule(avion.getMatricule());
        avionRepository.save(existingAvion);
        return existingAvion;
    }

    @Override
    public void delete(long id) {
        avionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehicule", "id", id));
        avionRepository.deleteById(id);
    }
}
