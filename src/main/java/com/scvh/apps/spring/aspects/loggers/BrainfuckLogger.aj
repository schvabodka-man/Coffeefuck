package com.scvh.apps.spring.aspects.loggers;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public aspect BrainfuckLogger {

    @Before("")
    public void beforeBrainfuckStart() {

    }

    @After("")
    public void afterBrainfuckFinished() {

    }

    @After("")
    public void newBrainfuckIterationStarted() {

    }
}
