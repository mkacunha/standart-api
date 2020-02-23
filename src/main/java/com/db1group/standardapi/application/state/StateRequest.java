package com.db1group.standardapi.application.state;

import com.db1group.standardapi.domain.state.State;
import com.db1group.standardapi.domain.state.StateCreateCommand;
import com.db1group.standardapi.infrastructure.aspect.Banana;

import java.util.function.Consumer;

public class StateRequest implements StateCreateCommand, Consumer<State> {

    private String name;

    @Override
    public String getName() {
        return this.name;
    }

    @Banana
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void accept(State state) {
        state.setName(this.name);
    }
}
