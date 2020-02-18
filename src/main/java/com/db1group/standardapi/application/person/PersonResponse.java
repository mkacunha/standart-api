package com.db1group.standardapi.application.person;

import com.db1group.standardapi.application.state.StateResponse;
import com.db1group.standardapi.domain.person.Person;

import java.util.UUID;

public class PersonResponse {

    private UUID id;

    private String name;

    private String document;

    private StateResponse state;

    public PersonResponse(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.document = person.getDocument();
        this.state = new StateResponse(person.getState());
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public StateResponse getState() {
        return state;
    }
}
