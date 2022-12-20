package cloud.avions.serviceImpl;

import cloud.avions.model.Avion;
import cloud.avions.repository.AssuranceRepository;
import cloud.avions.service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssuranceServiceImpl implements AssuranceService {

    @Autowired
    private AssuranceRepository assuranceRepository;

    // @Override
    // public List<Vehicule> getVehiculeFinAss(int mois) {

    // System.out.println(mois + " mons");
    // // System.out.println(assuranceRepository.getFinAssurance(mois));
    // return assuranceRepository.getFinAssurance(mois + " mons");
    // }

    @Override
    public List<Avion> getAvionFinAss(int mois) {

        System.out.println(mois + " mois");
        return assuranceRepository.getFinAssurance(mois);

    }

}
