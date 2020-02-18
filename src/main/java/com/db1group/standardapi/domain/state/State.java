package com.db1group.standardapi.domain.state;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class State {

    @Id
    private UUID id = UUID.randomUUID();

    @Column
    private String name;

    protected State() {
    }

    public static State of(StateCreateCommand command) {
        var state = new State();
        state.name = command.getName();
        return state;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
