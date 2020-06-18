package ninja.hara.springwebmvc.rest;

import ninja.hara.springwebmvc.exception.JediNotFoundException;
import ninja.hara.springwebmvc.model.Jedi;
import ninja.hara.springwebmvc.repository.JediRepository;
import ninja.hara.springwebmvc.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class JediResource {

    @Autowired
    private JediService service;

    @GetMapping("/api/jedi")
    public List<Jedi> getAllJedi() { //devolver uma lista de Jedi
        return service.findAll();
    }

    @GetMapping("/api/jedi/{id}")//recuperar o Jedi pelo id
    public ResponseEntity<Jedi> getJedi(@PathVariable("id") Long jediId) {
        return ResponseEntity.ok(service.findById(jediId));
    }

    @PostMapping("/api/jedi")
    @ResponseStatus(HttpStatus.CREATED)
    public Jedi createJedi(@Valid @RequestBody Jedi jedi) {
        return service.save(jedi);
    }

    @PutMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> updateJedi(@PathVariable("id") Long id, @Valid @RequestBody Jedi dto) {

        final Jedi jedi = service.update(id, dto);
        return ResponseEntity.ok(jedi);
    }

    @DeleteMapping("/api/jedi/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);

    }
}
