package com.ashwin.java.springbootpostgresql.api;

import com.ashwin.java.springbootpostgresql.model.Person;
import com.ashwin.java.springbootpostgresql.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody @NotNull Person person) {
        this.personService.addPerson(person);
    }

    @PostMapping(path = "bulk")
    public void addPeople(@RequestBody @NotNull List<Person> people) {
        this.personService.addPeople(people);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return this.personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return this.personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        this.personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody @NotNull @Valid Person person) {
        this.personService.updatePerson(id, person);
    }
}
