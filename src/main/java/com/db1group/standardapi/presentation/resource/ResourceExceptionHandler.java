package com.db1group.standardapi.presentation.resource;

import com.db1group.damagecontrol.handler.RuleExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ValidationException;
import java.lang.reflect.InvocationTargetException;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity handle(Exception e) {
        if (e instanceof ValidationException) {
            var it = (InvocationTargetException) e.getCause();
            var summary = new RuleExceptionHandler().apply((Exception) it.getTargetException());
            return ResponseEntity.status(summary.getStatus()).body(summary);
        }

        var summary = new RuleExceptionHandler().apply(e);
        return ResponseEntity.status(summary.getStatus()).body(summary);
    }
}
