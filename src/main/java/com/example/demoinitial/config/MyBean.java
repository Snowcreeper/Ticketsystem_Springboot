package com.example.demoinitial.config;

import com.example.demoinitial.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements CommandLineRunner {

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

        System.out.println("Command Line Runner ");
        myComponent.hello();
        System.out.println(felixMuster.toString());
        System.out.println(maxMustermann.toString());

    }
}
