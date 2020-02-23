package com.db1group.standardapi.application.person;

import com.db1group.standardapi.domain.person.PersonService;
import com.db1group.standardapi.domain.state.StateService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Transactional
public class PersonApplication {

    private final PersonService service;

    private final StateService stateService;

    public PersonApplication(PersonService service, StateService stateService) {
        this.service = service;
        this.stateService = stateService;
    }

    public PersonResponse create(PersonCreateRequest request) {
        var person = service.create(new PersonCreateRequestCommand(stateService, request));
        return new PersonResponse(person);
    }

    public List<PersonResponse> findAll() {
        return service.findAll().stream().map(PersonResponse::new).collect(Collectors.toList());
    }

    public PersonResponse update(UUID id, PersonUpdateNameRequest request) {
        var person = service.update(id, request);
        return new PersonResponse(person);
    }
}
