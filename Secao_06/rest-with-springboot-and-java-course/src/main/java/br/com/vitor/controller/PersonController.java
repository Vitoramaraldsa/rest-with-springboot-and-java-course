package br.com.vitor.controller;

import br.com.vitor.enums.RemoveStatus;
import br.com.vitor.exceptions.ResourceNotFoundException;
import br.com.vitor.model.Person;
import br.com.vitor.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    //retorna a busca de pessoas por id
    @GetMapping(value = "/{id}", produces = "application/json")
    Person getPerson(@PathVariable(value = "id") Long id){
        if(personService.findById(id).isEmpty()){
            throw new ResourceNotFoundException("Id not found.");
        }else{
            return personService.findById(id).get();
        }
    }

    //retorna todas as pessoas da base de dados
    @GetMapping(produces = "application/json")
    List<Person> getAllPersons(){
       List<Person> personsEntity = personService.findAll();
       if(personsEntity.isEmpty()){
           throw new ResourceNotFoundException("Persons not found.");
       }
         return personService.findAll();
    }

    //cria uma nova pessoa
     @PostMapping(produces = "application/json", consumes = "application/json")
     @ResponseStatus(HttpStatus.CREATED)
     Person addPerson(@RequestBody Person person){
        return personService.addPerson(person);
     }

    //cria uma nova pessoa
    @PutMapping(produces = "application/json", consumes = "application/json")
    Person updatePerson(@RequestBody Person person){
        if(personService.findById(person.getId()).isEmpty()){
            throw new ResourceNotFoundException("Person not found.");
        }else{
            return personService.updatePerson(person);
        }
    }

    //retorna a busca de pessoas por id
    @DeleteMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePerson(@PathVariable(value = "id") Long id){
         RemoveStatus removeStatus = personService.deleteById(id);
         if(removeStatus == RemoveStatus.NOT_EXISTS){
             throw new ResourceNotFoundException("Person not found.");
         }else if( removeStatus == RemoveStatus.REMOVE_ERROR){
             throw new InternalError("Contact Support.");
         }
    }

}
