package cloud.avions.serviceImpl;

import cloud.avions.exception.ResourceNotFoundException;
import cloud.avions.model.Kilometrage;
import cloud.avions.model.Avion;
import cloud.avions.repository.KilometrageRepository;
import cloud.avions.service.KilometrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KilometrageServiceImpl implements KilometrageService {

    @Autowired
    private KilometrageRepository kilometrageRepository;

    @Override
    public Kilometrage saveKilometrage(Kilometrage kilometrage) {
        return kilometrageRepository.save(kilometrage);
    }

    @Override
    public List<Kilometrage> getAllByAvion(Avion avion) {
        return kilometrageRepository.findAllByAvion(avion);
    }

    @Override
    public Kilometrage getKilometrageById(long id) {
        return kilometrageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Kilometrage", "id", id));
    }

    @Override
    public Kilometrage updateKilometrage(Kilometrage kilometrage, long id) {
        Kilometrage existingKilometrage = kilometrageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Kilometrage", "id", id));
        existingKilometrage.setAvion(kilometrage.getAvion());
        existingKilometrage.setDate(kilometrage.getDate());
        existingKilometrage.setKm_debut(kilometrage.getKm_debut());
        existingKilometrage.setKm_fin(kilometrage.getKm_fin());
        kilometrageRepository.save(existingKilometrage);
        return existingKilometrage;
    }

    @Override
    public void deleteKilometrage(long id) {
        kilometrageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Kilometrage", "id", id));
        kilometrageRepository.deleteById(id);
    }
}
