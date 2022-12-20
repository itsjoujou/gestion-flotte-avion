package application.controller;

import application.model.Kilometrage;
import application.repository.KilometrageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class KilometrageController {

    @Autowired
    private final KilometrageRepository repository;

    public KilometrageController(KilometrageRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/avions/{id_avion}/kilometrages")
    public List<Kilometrage> findKilometragesByAvion(@PathVariable("id_avion") int id_avion) {
        return repository.findByAvion(id_avion);
    }

    @GetMapping("/avions/{id_avion}/kilometrages/{id_km}")
    public Optional<Kilometrage> findKilometragesByID(@PathVariable("id_avion") int id_avion, @PathVariable("id_km") int id_km) {
        List<Kilometrage> kilometrages = repository.findByAvion(id_avion);

        return kilometrages.stream().filter(kilometrage -> id_km == kilometrage.getIdKilometrage()).findFirst();
    }

    @PostMapping("/kilometrages")
    public void create(@RequestBody Kilometrage newKilometrage) {
        repository.save(newKilometrage);
    }

    @PutMapping("/kilometrages/{id}")
    public void update(@RequestBody Kilometrage newKilometrage, @PathVariable int id) {
        repository.findById(id).map(kilometrage -> {
            kilometrage.setDateKM(newKilometrage.getDateKM());
            kilometrage.setDebut(newKilometrage.getDebut());
            kilometrage.setFin(newKilometrage.getFin());
            kilometrage.setVehicule(newKilometrage.getVehicule());

            return repository.save(kilometrage);
        });
    }

    @DeleteMapping("/kilometrages/{id}")
    public void delete(@PathVariable int id) {
        repository.deleteById(id);
    }
}