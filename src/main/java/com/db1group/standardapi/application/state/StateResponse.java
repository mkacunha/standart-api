package com.db1group.standardapi.application.state;

import com.db1group.standardapi.domain.state.State;

import java.util.UUID;

public class StateResponse {

    private UUID id;

    private String name;

    public StateResponse(State state) {
        this.id = state.getId();
        this.name = state.getName();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
