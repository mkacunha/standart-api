package com.db1group.standardapi.application.state;

import com.db1group.standardapi.domain.state.StateService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Component
@Transactional
public class StateApplication {

    private final StateService service;

    private final StateMapper mapper;

    public StateApplication(StateService service, StateMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public StateResponse create(StateRequest command) {
        var state = service.create(command);
        return mapper.apply(state);
    }

    public StateResponse update(UUID id, StateRequest command) {
        var state = service.update(id, command);
        return mapper.apply(state);
    }

    public List<StateResponse> findAll() {
        return mapper.apply(service.findAll());
    }
}
