package br.com.lincorp.springbootaws.service;

import br.com.lincorp.springbootaws.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {

        logger.info(String.format("Searching person by ID %s", id));

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Leandro");
        person.setLastName("Costa");
        person.setAddress("Uberlândia - Minas Gerais - Brasil");
        person.setGender("Male");

        return person;
    }
    
    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person create(Person person) {
        logger.info(String.format("Creating person %s", person.getFirstName()));
        return person;
    }

    public Person update(Person person) {
        logger.info(String.format("Updating person %s", person.getFirstName()));
        return person;
    }

    public void delete(String id) {
        logger.info(String.format("Deleting person by ID %s", id));
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person Name" + i);
        person.setLastName("Last Name" + i);
        person.setAddress("Some Address in Brasil" + i);
        person.setGender("Male");

        return person;
    }
}
