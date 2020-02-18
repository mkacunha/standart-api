package com.db1group.standardapi.domain.person;

import com.db1group.damagecontrol.rule.Rule;
import com.db1group.standardapi.domain.state.State;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
public class Person {

    @Id
    private UUID id = UUID.randomUUID();

    @Column
    private String name;

    @Column
    private String document;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

    protected Person() {
        // To JPA
    }

    public static Person of(PersonCreateCommand command) {
        Rule.check(command);
        var person = new Person();
        person.name = command.getName();
        person.document = command.getDocument();
        person.state = command.getState();
        return person;
    }

    public void setDocument(@NotNull(message = "Documento é obrigatório") String document) {
        this.document = document;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public State getState() {
        return state;
    }
}
