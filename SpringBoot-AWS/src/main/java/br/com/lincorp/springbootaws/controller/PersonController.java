package br.com.lincorp.springbootaws.controller;

import br.com.lincorp.springbootaws.model.Person;
import br.com.lincorp.springbootaws.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping ("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") String id) throws Exception {
        return service.findById(id);
    }

    @GetMapping("/all")
    public List<Person> findAll() {
        return service.findAll();
    }

    @PostMapping("/create")
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @PutMapping("/update")
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }
}
