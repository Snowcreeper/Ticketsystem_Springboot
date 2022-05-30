package com.example.demoinitial.config;

import com.example.demoinitial.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    public void hello() {
        System.out.println("Ich bin MyComponent");
    }

    @Bean(name="felixMuster")
    public Person getPerson() {
        Person person = new Person();
        person.setFirstName("Felix");
        person.setLastName("Muster");
        return person;
    }

    @Bean(name="maxMustermann")
    public Person getMaxMustermann() {
        Person person = new Person();
        person.setFirstName("Max");
        person.setLastName("Mustermann");
        return person;
    }

}
