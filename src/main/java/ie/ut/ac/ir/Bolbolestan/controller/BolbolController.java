package ie.ut.ac.ir.Bolbolestan.controller;

import ie.ut.ac.ir.Bolbolestan.dataAccess.mappers.BolbolMapper;
import ie.ut.ac.ir.Bolbolestan.model.Bolbol;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("bolbol")
public class BolbolController {

    private BolbolMapper mapper = BolbolMapper.getInstance();

    @PostMapping("/insert/{id}/{name}/{habitat}")
    public void insertBolbol(@PathVariable String id, @PathVariable String name, @PathVariable String habitat) throws SQLException {
        mapper.insert(new Bolbol(id, name, habitat));
    }

    @GetMapping("/find/{id}")
    public Bolbol findById(@PathVariable String id) throws SQLException {
        return mapper.findById(id);
    }

    @GetMapping("/find")
    public List<Bolbol> findAll() throws SQLException {
        return mapper.findAll();
    }
}
