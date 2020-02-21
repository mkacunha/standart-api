package com.db1group.standardapi.presentation.resource;

import com.db1group.standardapi.application.state.StateApplication;
import com.db1group.standardapi.application.state.StateRequest;
import com.db1group.standardapi.application.state.StateResponse;
import com.db1group.standardapi.domain.state.StateCreateCommand;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class StateResource {

    private final StateApplication application;

    public StateResource(StateApplication application) {
        this.application = application;
    }

    @PostMapping("/api/states")
    public StateResponse post(@RequestBody StateRequest command) {
        return application.create(command);
    }


    @PutMapping("/api/states/{id}")
    public StateResponse put(@PathVariable("id") UUID id, @RequestBody StateRequest command) {
        return application.update(id, command);
    }


    @GetMapping("/api/states")
    public List<StateResponse> findAll(StateCreateCommand command) {
        return application.findAll();
    }
}
