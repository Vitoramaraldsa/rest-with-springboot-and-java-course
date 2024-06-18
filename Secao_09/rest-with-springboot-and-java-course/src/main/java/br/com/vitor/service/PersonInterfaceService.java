package br.com.vitor.service;

import br.com.vitor.data.vo.V1.PersonVo;
import br.com.vitor.exceptions.ResourceNotFoundException;

import java.util.List;


public interface PersonInterfaceService {

     //busca por uma pessoa com base no id
     PersonVo findById(Long id) throws ResourceNotFoundException;
     //busca por todas as pessoas
     List<PersonVo> findAll() throws ResourceNotFoundException;
     //adiciona uma nova pessoa
     PersonVo addPerson(PersonVo person);
     //atualiza uma pessoa
     PersonVo updatePerson(PersonVo person);
     //deleta uma pessoa com base no id
     void deleteById(Long id) throws ResourceNotFoundException;
}
