package com.db1group.standardapi.application.person;

import com.db1group.standardapi.domain.person.PersonCreateCommand;
import com.db1group.standardapi.domain.state.State;
import com.db1group.standardapi.domain.state.StateService;
import com.db1group.standardapi.infrastructure.BeanUtils;

import java.util.Objects;
import java.util.UUID;

public class PersonCreateRequest implements PersonCreateCommand {

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

    public void setDocument(String document) {
        this.document = document;
    }

    public UUID getStateId() {
        return stateId;
    }

    public void setStateId(UUID stateId) {
        this.stateId = stateId;
    }

    @Override
    public State getState() {
        if (Objects.nonNull(stateId)) {
            return BeanUtils.getBean(StateService.class).findById(this.stateId);
        }
        return null;
    }
}
