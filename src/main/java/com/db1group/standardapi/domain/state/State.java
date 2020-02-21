package com.db1group.standardapi.domain.state;

import com.db1group.damagecontrol.rule.Rule;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;
import java.util.function.Consumer;

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
        state.setName(command.getName());
        return state;
    }

    public void update(Consumer<State> update) {
        update.accept(this);
    }

    public UUID getId() {
        return id;
    }

    public void setName(String name) {
        Rule.isNotBlank(name, "Nome é obrigatório");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
