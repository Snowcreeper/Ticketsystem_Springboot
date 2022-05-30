package com.example.demoinitial.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements CommandLineRunner {

    MyComponent myComponent;
    @Autowired
    public MyBean(MyComponent myComponent) {
        this.myComponent = myComponent;
    }
    @Override
    public void run(String... args) throws Exception {

        System.out.println("Command Line Runner ");
        myComponent.hello();

    }
}
