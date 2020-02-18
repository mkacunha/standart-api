package com.db1group.standardapi.application.person;

import com.db1group.standardapi.domain.person.PersonSet;
import com.db1group.standardapi.domain.state.State;

import java.util.function.Consumer;

public class PersonUpdateRequest implements Consumer<PersonSet> {

    private String name;

    private String document;

    private State state;

    @Override
    public void accept(PersonSet personSet) {
        personSet.setName(this.name);
        personSet.setDocument(this.document);
        personSet.setState(this.state);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
