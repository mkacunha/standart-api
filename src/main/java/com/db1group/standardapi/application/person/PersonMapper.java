package com.db1group.standardapi.application.person;

import com.db1group.standardapi.domain.person.Person;
import com.db1group.standardapi.infrastructure.Mapper;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper implements Mapper<Person, PersonResponse> {

    @Override
    public PersonResponse apply(Person person) {
        return new PersonResponse(person);
    }
}
