package br.com.vitor.service;

import br.com.vitor.data.vo.V1.PersonVo;
import br.com.vitor.exceptions.ResourceNotFoundException;
import br.com.vitor.mapper.DozerMapper;
import br.com.vitor.model.Person;
import br.com.vitor.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PersonService implements PersonInterfaceService{

    @Autowired
    private PersonRepository repository;
    private Logger logger = Logger.getLogger(Person.class.getName());

    public PersonVo findById(Long id) {
        logger.info("Finding person by id...");
        var entity = repository.findById(id);
        if (entity.isEmpty()){
            throw new ResourceNotFoundException("Id não encontrado");
        }
        return DozerMapper.parseObject(entity.get(),PersonVo.class);
    }


    //procura por todas as pessoas cadastradas no banco de dados
    public List<PersonVo> findAll(){
        logger.info("Finding all persons...");
        List<PersonVo> personsList = DozerMapper.parseListObjects(repository.findAll(),PersonVo.class);
        if(personsList.isEmpty()){
            throw new ResourceNotFoundException("Persons not found");
        }
        return personsList;
    }

    //adiciona uma nova pessoa ao banco de dados
    public PersonVo addPerson(PersonVo person) {
        logger.info("Adding person...");
        var entity = DozerMapper.parseObject(person,Person.class);
        return DozerMapper.parseObject(repository.save(entity), PersonVo.class);
    }

    //atualiza as informações da pessoa
    public PersonVo updatePerson(PersonVo person){
        logger.info("Updating person...");
        var entity = DozerMapper.parseObject(person,Person.class);
        if(repository.findById(person.getId()).isEmpty()){
            throw new ResourceNotFoundException("Pessoa não localizada.");
        }
        return DozerMapper.parseObject(repository.save(entity), PersonVo.class);

    }

    //deleta as pessoas com base no id
    
    public void deleteById(Long id) {
        logger.info("Deleting person by id...");
        var entity = repository.findById(id);
        //caso o id não exista na base de dados
        if(entity.isEmpty()){
            throw new ResourceNotFoundException("Id não localizado");
        }
        //caso exista, remover da base de dados
        repository.deleteById(id);
        if(!repository.findById(id).isEmpty()){
            throw new InternalError("Erro ao excluir");
        }
    }
}
