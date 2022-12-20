package application.controller;

import application.model.AvionEntity;
import application.service.AvionService;
import application.util.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/avions")
@RestController
public class AvionController {
    @Autowired
    private final AvionService service;

    public AvionController(AvionService service) {
        this.service = service;
    }

    @GetMapping("/expired/{monthDuration}")
    public Data vehiculeWithAssuranceExpiredIn(@PathVariable int monthDuration) {
        return service.findAllAvionWithAssuranceExpiredIn(monthDuration);
    }

    @GetMapping
    public Data all() {
        return service.getAvions();
    }

    @GetMapping("/{id}")
    public Data detail(@PathVariable int id) {
        return service.getAvion(id);
    }

    @PostMapping
    public void create(@RequestBody AvionEntity newAvion) {
        service.save(newAvion);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody AvionEntity newAvion, @PathVariable int id){
        service.update(newAvion, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }
}
