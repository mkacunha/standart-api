package com.db1group.standardapi.presentation.resource;

import com.db1group.standardapi.application.person.PersonApplication;
import com.db1group.standardapi.application.person.PersonCreateRequest;
import com.db1group.standardapi.application.person.PersonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonResource {

    private final PersonApplication application;

    public PersonResource(PersonApplication application) {
        this.application = application;
    }

    @GetMapping("/api/people")
    public List<PersonResponse> getAll() {
        return application.findAll();
    }

    @PostMapping("/api/people")
    public PersonResponse post(@RequestBody PersonCreateRequest request) {
        return application.create(request);
    }
}
