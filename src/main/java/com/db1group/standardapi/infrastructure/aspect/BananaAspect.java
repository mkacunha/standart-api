package com.db1group.standardapi.infrastructure.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class BananaAspect {

    private final AutowireCapableBeanFactory beanFactory;

    public BananaAspect(AutowireCapableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping)" +
            " || @annotation(org.springframework.web.bind.annotation.GetMapping)" +
            " || @annotation(org.springframework.web.bind.annotation.PutMapping)" +
            " || @annotation(org.springframework.web.bind.annotation.DeleteMapping)" +
            " || @annotation(org.springframework.web.bind.annotation.PatchMapping)")
    public void aplicarBanana(JoinPoint joinPoint) {
        for (Object object : joinPoint.getArgs()) {
            beanFactory.autowireBean(object);
        }
    }
}
