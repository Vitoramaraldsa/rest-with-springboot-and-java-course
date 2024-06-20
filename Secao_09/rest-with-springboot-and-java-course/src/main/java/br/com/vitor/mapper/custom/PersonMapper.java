package br.com.vitor.mapper.custom;

import br.com.vitor.data.vo.V1.PersonVo;
import br.com.vitor.data.vo.V2.PersonVoV2;
import br.com.vitor.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PersonMapper {

    public PersonVoV2 convertEntityToVo(Person person){
        PersonVoV2 vo = new PersonVoV2();
        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setGender(person.getGender());
        vo.setBirthDay(new Date());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        return vo;
    }

    public Person convertVoToEntity(PersonVoV2 vo){
        Person personEntity = new Person();
        personEntity.setId(vo.getId());
        personEntity.setAddress(vo.getAddress());
        personEntity.setGender(vo.getGender());
        //personEntity.setBirthDay(new Date());
        personEntity.setFirstName(vo.getFirstName());
        personEntity.setLastName(vo.getLastName());
        return personEntity;
    }

    public List<PersonVoV2> convertListEntityToVo(List<Person> listPerson){
        List<PersonVoV2> destinationArrayVo = new ArrayList<PersonVoV2>();
        //itera sobre as pessoas da lista
        for(Person p : listPerson){
            //cria um novo objeto PersonVOV2
            PersonVoV2 vo = new PersonVoV2();
            vo.setId(p.getId());
            vo.setAddress(p.getAddress());
            vo.setGender(p.getGender());
            vo.setBirthDay(new Date());
            vo.setFirstName(p.getFirstName());
            vo.setLastName(p.getLastName());
            destinationArrayVo.add(vo);
        }
        return destinationArrayVo;
    }
}
