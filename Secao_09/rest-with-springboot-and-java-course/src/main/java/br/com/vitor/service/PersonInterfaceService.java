package br.com.vitor.service;

import br.com.vitor.data.vo.V1.PersonVo;
import br.com.vitor.data.vo.V2.PersonVoV2;
import br.com.vitor.exceptions.ResourceNotFoundException;

import java.util.List;


public interface PersonInterfaceService {

     //v1
     //busca por uma pessoa com base no id
     PersonVo findById(Long id) throws ResourceNotFoundException;
     //busca por todas as pessoas
     List<PersonVo> findAll() throws ResourceNotFoundException;
     //adiciona uma nova pessoa
     PersonVo addPerson(PersonVo person);
     //atualiza uma pessoa
     PersonVo updatePerson(PersonVo person);


     //v2
     //busca por uma pessoa com base no id
     PersonVoV2 findByIdV2(Long id) throws ResourceNotFoundException;
     //busca por todas as pessoas
     List<PersonVoV2> findAllV2() throws ResourceNotFoundException;
     //adiciona uma nova pessoa
     PersonVoV2 addPersonV2(PersonVoV2 person);
     //atualiza uma pessoa
     PersonVoV2 updatePersonV2(PersonVoV2 person);
     //deleta uma pessoa com base no id
     void deleteById(Long id) throws ResourceNotFoundException;
}
