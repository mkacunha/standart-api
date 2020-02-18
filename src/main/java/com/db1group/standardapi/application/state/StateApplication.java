package com.db1group.standardapi.application.state;

import com.db1group.standardapi.domain.state.StateCreateCommand;
import com.db1group.standardapi.domain.state.StateService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StateApplication {

    private final StateService service;

    private final StateMapper mapper;

    public StateApplication(StateService service, StateMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public StateResponse create(StateCreateCommand command) {
        var state = service.create(command);
        return mapper.apply(state);
    }

    public List<StateResponse> findAll() {
        return mapper.apply(service.findAll());
    }
}
