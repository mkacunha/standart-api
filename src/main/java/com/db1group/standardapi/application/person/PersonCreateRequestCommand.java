package com.db1group.standardapi.application.person;

import com.db1group.standardapi.domain.person.PersonCreateCommand;
import com.db1group.standardapi.domain.state.State;
import com.db1group.standardapi.domain.state.StateService;

public class PersonCreateRequestCommand implements PersonCreateCommand {

    private final StateService stateService;

    private final PersonCreateRequest request;

    public PersonCreateRequestCommand(StateService stateService, PersonCreateRequest request) {
        this.stateService = stateService;
        this.request = request;
    }

    @Override
    public String getName() {
        return request.getName();
    }

    @Override
    public String getDocument() {
        return request.getDocument();
    }

    @Override
    public State getState() {
        return stateService.findById(request.getStateId());
    }
}
