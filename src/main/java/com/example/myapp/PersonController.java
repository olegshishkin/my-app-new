package com.example.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private final PersonRepository repository;

    @Autowired
    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/a")
    public Person index() {
        return new Person();
    }

    @GetMapping("/add")
    public List<Person> add(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        repository.save(person);
        return repository.findAll();
    }

    @GetMapping("/get/{name}")
    public Person get(@PathVariable("name") String name) {
        return repository.findByName(name);
    }
}
