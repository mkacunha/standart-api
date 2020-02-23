package com.db1group.standardapi.application.person;

import com.db1group.standardapi.domain.person.PersonService;
import com.db1group.standardapi.domain.state.StateService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Component
@Transactional
public class PersonApplication {

    private final PersonService service;

    private final PersonMapper mapper;

    private final StateService stateService;

    public PersonApplication(PersonService service, PersonMapper mapper, StateService stateService) {
        this.service = service;
        this.mapper = mapper;
        this.stateService = stateService;
    }

    public PersonResponse create(PersonCreateRequest request) {
        var person = service.create(new PersonCreateRequestCommand(stateService, request));
        return mapper.apply(person);
    }

    public List<PersonResponse> findAll() {
        return mapper.apply(service.findAll());
    }

    public PersonResponse update(UUID id, PersonUpdateNameRequest request) {
        var person = service.update(id, request);
        return mapper.apply(person);
    }
}
