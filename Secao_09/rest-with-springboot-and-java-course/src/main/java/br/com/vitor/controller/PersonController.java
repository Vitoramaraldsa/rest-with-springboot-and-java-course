package br.com.vitor.controller;

import br.com.vitor.data.vo.V1.PersonVo;
import br.com.vitor.exceptions.ResourceNotFoundException;
import br.com.vitor.mapper.DozerMapper;
import br.com.vitor.model.Person;
import br.com.vitor.service.PersonService;
import org.apache.catalina.mapper.Mapper;
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
    PersonVo getPerson(@PathVariable(value = "id") Long id){
       return personService.findById(id);
    }

    //retorna todas as pessoas da base de dados
    @GetMapping(produces = "application/json")
    List<PersonVo> getAllPersons(){
         return personService.findAll();
    }

    //cria uma nova pessoa
     @PostMapping(produces = "application/json", consumes = "application/json")
     @ResponseStatus(HttpStatus.CREATED)
     PersonVo addPerson(@RequestBody PersonVo person){
        return personService.addPerson(person);
     }

    //cria uma nova pessoa
    @PutMapping(produces = "application/json", consumes = "application/json")
    PersonVo updatePerson(@RequestBody PersonVo person){
        return personService.updatePerson(person);
    }

    //retorna a busca de pessoas por id
    @DeleteMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePerson(@PathVariable(value = "id") Long id){
         personService.deleteById(id);
    }

}
