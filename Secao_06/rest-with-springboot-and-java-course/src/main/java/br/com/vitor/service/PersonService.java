package br.com.vitor.service;

import br.com.vitor.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong count = new AtomicLong();
    private Logger logger = Logger.getLogger(Person.class.getName());

    public Person findById(String id){
        logger.info("Finding person...");
        return new Person(
                count.incrementAndGet(),
                "Vitor",
                "Souza",
                "Av. Afonso Valera",
                "Male"
        );
    }

    public ArrayList<Person> findAll(){
        logger.info("Finding all persons...");
        ArrayList<Person> personsList = mockPeoples();
        return personsList;
    }

    private ArrayList<Person> mockPeoples() {
        ArrayList<Person> personsListMock = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            Long id = count.incrementAndGet();
            personsListMock.add(new Person(id,"vitor" + id ,"amaral" + id,"Av.Afonso Valera" + id,"Male"));
        }
        return personsListMock;
    }

    public Person addPerson(Person person) {
        logger.info("Adding person...");
        return person;
    }

    public Person updatePerson(Person person) {
        logger.info("Updating person...");
        return person;
    }

    public void deleteById(String id) {
        logger.info("Deleting person...");
    }
}
