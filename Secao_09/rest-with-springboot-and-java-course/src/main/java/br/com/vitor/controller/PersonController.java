package br.com.vitor.controller;

import br.com.vitor.data.vo.V1.PersonVo;
import br.com.vitor.data.vo.V2.PersonVoV2;
import br.com.vitor.exceptions.ResourceNotFoundException;
import br.com.vitor.mapper.DozerMapper;
import br.com.vitor.model.Person;
import br.com.vitor.service.PersonService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/person")
@Tag(name = "People", description = "Endpoint for manage peoples")
public class PersonController {

    @Autowired
    private PersonService personService;


    //retorna a busca de pessoas por id
    @GetMapping(value = "/v1/{id}", produces = {"application/json","application/xml"})
    PersonVo getPerson(@PathVariable(value = "id") Long id){
       return personService.findById(id);
    }

    //retorna todas as pessoas da base de dados
    @GetMapping(value = "/v1", produces = {"application/json","application/xml"})
    List<PersonVo> getAllPersons(){
         return personService.findAll();
    }

    //cria uma nova pessoa
     @PostMapping(value = "/v1", produces = {"application/json","application/xml"}, consumes = "application/json")
     @ResponseStatus(HttpStatus.CREATED)
     PersonVo addPerson(@RequestBody PersonVo person){
        return personService.addPerson(person);
     }

    //cria uma nova pessoa
    @PutMapping(value = "/v1" , produces = {"application/json","application/xml"}, consumes = "application/json")
    PersonVo updatePerson(@RequestBody PersonVo person){
        return personService.updatePerson(person);
    }

    //retorna a busca de pessoas por id
    @DeleteMapping(value = "/v1/{id}", produces = {"application/json","application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePerson(@PathVariable(value = "id") Long id){
         personService.deleteById(id);
    }

    //V2 Controllers

    //retorna a busca de pessoas por id
    @GetMapping(value = "/v2/{id}", produces = {"application/json","application/xml"})
    PersonVoV2 getPersonV2(@PathVariable(value = "id") Long id){
        return personService.findByIdV2(id);
    }

    //retorna todas as pessoas da base de dados
    @GetMapping(value = "/v2", produces = {"application/json","application/xml"})
    List<PersonVoV2> getAllPersonsV2(){
        return personService.findAllV2();
    }

    //cria uma nova pessoa
    @PostMapping(value = "/v2", produces = {"application/json","application/xml"}, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    PersonVoV2 addPersonV2(@RequestBody PersonVoV2 person){
        return personService.addPersonV2(person);
    }

    //cria uma nova pessoa
    @PutMapping(value = "/v2", produces = {"application/json","application/xml"}, consumes = "application/json")
    PersonVoV2 updatePersonV2(@RequestBody PersonVoV2 person){
        return personService.updatePersonV2(person);
    }

    //retorna a busca de pessoas por id, apenas a rota foi alterada para fins de conformidade
    @DeleteMapping(value = "/v2/{id}", produces = {"application/json","application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePersonV2(@PathVariable(value = "id") Long id){
        personService.deleteById(id);
    }

}
