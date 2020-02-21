package com.db1group.standardapi.domain.person;

import com.db1group.damagecontrol.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

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

    public Person update(UUID id, Consumer<Person> command) {
        var person = repository.findById(id).orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));
        person.update(command);
        return repository.save(person);
    }

}
