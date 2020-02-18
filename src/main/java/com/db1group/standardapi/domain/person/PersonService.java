package com.db1group.standardapi.domain.person;

import com.db1group.standardapi.application.person.PersonUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person create(PersonCreateCommand command) {
        var person = Person.of(command);
        return repository.save(person);
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public void update(PersonUpdateRequest request) {
        var person = new PersonSet();
        person.update(request);
    }

}
