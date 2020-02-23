package com.db1group.standardapi.domain.person;

import com.db1group.damagecontrol.rule.Rule;
import com.db1group.standardapi.domain.state.State;
import com.db1group.standardapi.infrastructure.Command;

import javax.persistence.*;
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

    public static Person of(PersonCreateCommand command) {
        var person = new Person();
        person.setName(command.getName());
        person.setDocument(command.getDocument());
        person.setState(command.getState());
        return person;
    }

    public void execute(Command<Person> command) {
        command.execute(this);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Rule.isNotBlank(name, "Nome é obrigatório");
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        Rule.isNotBlank(document, "Documento é obrigatório");
        this.document = document;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        Rule.isNotNull(state, "Estado é obrigatório");
        this.state = state;
    }
}
