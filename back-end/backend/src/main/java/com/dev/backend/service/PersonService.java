package com.dev.backend.service;

import com.dev.backend.entity.Person;
import com.dev.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> searchAll(){
        return personRepository.findAll();
    }

    public Person insert(Person person){
        person.setDateCreation(new Date());
        Person personNew = personRepository.saveAndFlush(person);
        return personNew;
    }

    public Person modify(Person person){
        person.setDateUpdate(new Date());
        return personRepository.saveAndFlush(person);
    }

    public void delete(Long id){
        Person person = personRepository.findById(id).get();
        personRepository.delete(person);
    }
}
