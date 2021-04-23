package ie.ut.ac.ir.Bolbolestan.controller;

import ie.ut.ac.ir.Bolbolestan.repository.BolbolRepository;
import ie.ut.ac.ir.Bolbolestan.model.Bolbol;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("bolbol")
public class BolbolController {

    private BolbolRepository repository = BolbolRepository.getInstance();

    @PostMapping("/insert/{id}/{name}/{habitat}")
    public void insertBolbol(@PathVariable String id, @PathVariable String name, @PathVariable String habitat) throws SQLException {
        repository.insert(new Bolbol(id, name, habitat));
    }

    @GetMapping("/find/{id}")
    public Bolbol findById(@PathVariable String id) throws SQLException {
        return repository.findById(id);
    }

    @GetMapping("/find")
    public List<Bolbol> findAll() throws SQLException {
        return repository.findAll();
    }
}
