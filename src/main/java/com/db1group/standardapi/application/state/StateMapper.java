package com.db1group.standardapi.application.state;

import com.db1group.standardapi.domain.state.State;
import com.db1group.standardapi.infrastructure.Mapper;
import org.springframework.stereotype.Component;

@Component
public class StateMapper implements Mapper<State, StateResponse> {

    @Override
    public StateResponse apply(State state) {
        return new StateResponse(state);
    }
}
