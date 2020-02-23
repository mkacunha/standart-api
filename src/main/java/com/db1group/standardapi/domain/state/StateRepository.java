package com.db1group.standardapi.domain.state;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StateRepository extends JpaRepository<State, UUID> {

    boolean existsByName(String name);
}
