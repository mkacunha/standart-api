package com.db1group.standardapi.application.person;

import com.db1group.standardapi.domain.person.PersonCreateCommand;
import com.db1group.standardapi.domain.state.State;
import com.db1group.standardapi.domain.state.StateService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class PersonCreateRequest implements PersonCreateCommand {

    @Autowired
    private StateService stateService;

    private String name;

    private String document;

    private UUID stateId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    @Override
    public State getState() {
        return stateService.findById(this.getStateId());
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public UUID getStateId() {
        return stateId;
    }

    public void setStateId(UUID stateId) {
        this.stateId = stateId;
    }
}
