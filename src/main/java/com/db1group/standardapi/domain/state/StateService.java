package com.db1group.standardapi.domain.state;

import com.db1group.damagecontrol.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StateService {

    private final StateRepository repository;

    public StateService(StateRepository repository) {
        this.repository = repository;
    }

    public State create(StateCreateCommand command) {
        return repository.save(State.of(command));
    }

    public List<State> findAll() {
        return repository.findAll();
    }

    public State findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Estado não encontrado"));
    }


}
