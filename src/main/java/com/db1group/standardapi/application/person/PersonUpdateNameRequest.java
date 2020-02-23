package com.db1group.standardapi.application.person;

import com.db1group.standardapi.domain.person.Person;
import com.db1group.standardapi.infrastructure.Command;

public class PersonUpdateNameRequest implements Command<Person> {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void execute(Person person) {
        person.setName(this.name);
    }
}
