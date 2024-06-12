package br.com.vitor.service;

import br.com.vitor.enums.RemoveStatus;
import br.com.vitor.exceptions.ResourceNotFoundException;
import br.com.vitor.model.Person;
import br.com.vitor.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;
    private Logger logger = Logger.getLogger(Person.class.getName());

    public Optional<Person> findById(Long id){
            return repository.findById(id);
    }

    //procura por todas as pessoas cadastradas no banco de dados
    public List<Person> findAll(){
        logger.info("Finding all persons...");
        List<Person> personsList = repository.findAll();
        return personsList;
    }

    //adiciona uma nova pessoa ao banco de dados
    public Person addPerson(Person person) {
        logger.info("Adding person...");
        return repository.save(person);
    }

    //atualiza as informações da pessoa
    public Person updatePerson(Person person){
        if(repository.findById(person.getId()).isEmpty()){
            throw new ResourceNotFoundException("Person not found.");
        }else{
           return repository.save(person);
        }
    }

    public RemoveStatus deleteById(Long id) {
        //caso o id não exista na base de dados
        if(findById(id).isEmpty()){
            return RemoveStatus.NOT_EXISTS;
        }
        //caso exista, remover da base de dados
        repository.deleteById(id);
        if(repository.findById(id).isEmpty()){
            return RemoveStatus.REMOVED;
        }else{
            return RemoveStatus.REMOVE_ERROR;
        }
    }
}
