package com.scvh.apps.spring.aspects.loggers;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public aspect WebLogger {

    @Before("")
    public void enteredMainPage() {

    }

    @Before("")
    public void receivedError() {

    }

}
