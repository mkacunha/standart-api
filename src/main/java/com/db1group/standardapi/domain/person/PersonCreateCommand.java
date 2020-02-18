package com.db1group.standardapi.domain.person;

import com.db1group.standardapi.domain.state.State;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public interface PersonCreateCommand {

    @NotNull(message = "Nome é obrigatório")
    String getName();

    @NotNull(message = "Documento é obrigatório")
    String getDocument();

    @NotNull(message = "Estado é obrigatório")
    State getState();

    @AssertTrue(message = "Documento informado inválido")
    default boolean isDocumentValid() {
        if (Objects.nonNull(getDocument())) {
            return getDocument().length() == 9;
        }
        return true;
    }
}