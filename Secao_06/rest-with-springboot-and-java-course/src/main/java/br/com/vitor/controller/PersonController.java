package br.com.vitor.controller;

import br.com.vitor.model.Person;
import br.com.vitor.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    //retorna a busca de pessoas por id
    @GetMapping(value = "/{id}", produces = "application/json")
    Person getPerson(@PathVariable(value = "id") String id){
        return personService.findById(id);
    }

    //retorna todas as pessoas da base de dados
    @GetMapping(produces = "application/json")
    ArrayList<Person> getAllPersons(){
        return personService.findAll();
    }

    //cria uma nova pessoa
     @PostMapping(produces = "application/json", consumes = "application/json")
     Person addPerson(@RequestBody Person person){
        return personService.addPerson(person);
     }

    //cria uma nova pessoa
    @PutMapping(produces = "application/json", consumes = "application/json")
    Person updatePerson(@RequestBody Person person){
        return personService.updatePerson(person);
    }

    //retorna a busca de pessoas por id
    @DeleteMapping(value = "/{id}", produces = "application/json")
    void deletePerson(@PathVariable(value = "id") String id){
         personService.deleteById(id);
    }

}
