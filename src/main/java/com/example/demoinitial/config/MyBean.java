package com.example.demoinitial.config;

import com.example.demoinitial.domain.Person;
import com.example.demoinitial.utils.HasLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements CommandLineRunner, HasLogger {

    private final MyComponent myComponent;

    @Autowired
    @Qualifier("felixMuster")
    private Person felixMuster;

    @Autowired
    @Qualifier("maxMustermann")
    private Person maxMustermann;

    @Autowired
    public MyBean(MyComponent myComponent) {
        this.myComponent = myComponent;
    }
    @Override
    public void run(String... args) throws Exception {

        getLogger().debug("Command Line Runner ");
        myComponent.hello();
        getLogger().debug(felixMuster.toString());
        getLogger().debug(maxMustermann.toString());
        getLogger().debug("getTestValue = " + myComponent.getTestValue());

    }
}
