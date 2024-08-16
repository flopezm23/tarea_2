package persona.ejercicio_CRUD.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import persona.ejercicio_CRUD.CRUD.Servicio_Persona;
import persona.ejercicio_CRUD.Persona.Pessoa;

@RestController
@RequestMapping("/api/persons")
public class Vista {
      @Autowired
    private Servicio_Persona personService;

    @GetMapping
    public List<Pessoa> getAllPersons() {
        return personService.getAllPersons();
    }

    @PostMapping
    public void addPerson(@RequestBody Pessoa person) {
        personService.Registrar(person);
    }

    @PutMapping("/{id}")
    public void updatePerson(@PathVariable Long id, @RequestBody Pessoa person) {
    person.setId(id);
    personService.Atualizar(person);
    }//cierre actualizar persona

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
    personService.Deletar(id);
    }//cierre eliminar


}
