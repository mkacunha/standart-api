package com.db1group.standardapi.application.person;

import com.db1group.standardapi.domain.person.Person;

import java.util.function.Consumer;

public class PersonUpdateNameRequest implements Consumer<Person> {

    private String name;

    @Override
    public void accept(Person person) {
        person.setName(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
