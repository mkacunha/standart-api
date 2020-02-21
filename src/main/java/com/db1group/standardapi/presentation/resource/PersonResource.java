package com.db1group.standardapi.presentation.resource;

import com.db1group.standardapi.application.person.PersonApplication;
import com.db1group.standardapi.application.person.PersonCreateRequest;
import com.db1group.standardapi.application.person.PersonResponse;
import com.db1group.standardapi.application.person.PersonUpdateNameRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PutMapping("/api/people/{id}")
    public PersonResponse post(@PathVariable("id") UUID id, @RequestBody PersonUpdateNameRequest request) {
        return application.update(id, request);
    }
}
