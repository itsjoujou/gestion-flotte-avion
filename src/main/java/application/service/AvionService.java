package application.service;

import application.model.AvionEntity;
import application.repository.AvionDetailRepository;
import application.repository.AvionRepository;
import application.util.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvionService {
    @Autowired
    private final AvionRepository avionRepository;

    @Autowired
    private final AvionDetailRepository avionDetailRepository;

    public AvionService(AvionRepository avionRepository, AvionDetailRepository avionDetailRepository) {
        this.avionRepository = avionRepository;
        this.avionDetailRepository = avionDetailRepository;
    }

    public Data findAllAvionWithAssuranceExpiredIn(int monthDuration) {
        Data data = new Data();
        data.setData(avionRepository.findAllAvionWithAssuranceExpiredIn(monthDuration));

        return data;
    }


    public Data getAvions() {
        Data data = new Data();
        data.setData(avionRepository.findAll());

        return data;
    }

    public Data getAvion(int id) {
        Data data = new Data();
        data.setData(avionDetailRepository.findById(id));

        return data;
    }

    public void save(AvionEntity newVehicule) {
        avionRepository.save(newVehicule);
    }

    public void update(AvionEntity newVehicule, int id) {
        avionRepository.findById(id).map(vehicule -> {
            vehicule.setAnnee(newVehicule.getAnnee());
            vehicule.setModele(newVehicule.getModele());

            return avionRepository.save(vehicule);
        });
    }

    public void delete(int id) {
        avionRepository.deleteById(id);
    }
}
