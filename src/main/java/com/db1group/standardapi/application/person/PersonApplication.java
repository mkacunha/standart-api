package com.db1group.standardapi.application.person;

import com.db1group.standardapi.domain.person.PersonService;
import com.db1group.standardapi.domain.state.StateService;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class PersonApplication {

    private final PersonService service;

    private final PersonMapper mapper;

    private final StateService stateService;

    public PersonApplication(PersonService service, PersonMapper mapper, StateService stateService) {
        this.service = service;
        this.mapper = mapper;
        this.stateService = stateService;
    }

    @Transactional
    public PersonResponse create(PersonCreateRequest request) {
        var person = service.create(request);
        return mapper.apply(person);
    }

    @Transactional
    public List<PersonResponse> findAll() {
        return mapper.apply(service.findAll());
    }

}
