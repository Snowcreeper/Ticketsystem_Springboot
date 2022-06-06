package com.example.demoinitial.config;

import com.example.demoinitial.domain.Person;
import com.example.demoinitial.repository.PersonRepository;
import com.example.demoinitial.utils.HasLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Sort;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Defines a Bean for the dev-Profile
 */
@Configuration
@Profile("dev")
// @ConditionalOnClass(name = {"org.h2.Driver"})
public class DevConfiguration implements HasLogger {


    @Autowired
    PersonRepository personRepository;

    @Autowired
    @Qualifier("felixMuster")
    private Person felixMuster;

    @Autowired
    @Qualifier("maxMustermann")
    private Person maxMustermann;


    public DevConfiguration() {
        getLogger().info("Dev Configuration Class");
    }

    @PostConstruct
    public void createPersonData() {
        if (personRepository.findByFirstNameAndLastName(felixMuster.getFirstName(), felixMuster.getLastName()).isEmpty()) {
            personRepository.save(felixMuster);
            getLogger().debug("Person felixMuster saved to DB");
        }
        if (personRepository.findByFirstNameAndLastName(maxMustermann.getFirstName(), maxMustermann.getLastName()).isEmpty()) {
            personRepository.save(maxMustermann);
            getLogger().debug("Person maxMustermann saved to DB");
        }

        List<Person> persons = personRepository.findQueryByLastName("Mustermann");
        persons.forEach(person -> getLogger().debug("person.toString() = " + person.toString()));

        personRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName")).forEach(person -> {
            personRepository.findById(person.getId())
                    .ifPresent(p -> getLogger().debug("person.toString() = " + p.toString()));
        });
    }
}
