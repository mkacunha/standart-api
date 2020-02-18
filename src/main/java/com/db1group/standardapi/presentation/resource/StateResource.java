package com.db1group.standardapi.presentation.resource;

import com.db1group.standardapi.application.state.StateApplication;
import com.db1group.standardapi.application.state.StateResponse;
import com.db1group.standardapi.domain.state.StateCreateCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StateResource {

    private final StateApplication application;

    public StateResource(StateApplication application) {
        this.application = application;
    }

    @PostMapping("/api/states")
    public StateResponse post(@RequestBody StateCreateCommand command) {
        return application.create(command);
    }


    @GetMapping("/api/states")
    public List<StateResponse> findAll(StateCreateCommand command) {
        return application.findAll();
    }
}
