package com.db1group.standardapi.domain.person;

import com.db1group.standardapi.domain.state.State;

public interface PersonCreateCommand {

    String getName();

    String getDocument();

    State getState();
}