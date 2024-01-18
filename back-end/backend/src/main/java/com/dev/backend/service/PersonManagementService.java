package com.dev.backend.service;

import com.dev.backend.dto.PersonClientRequestDTO;
import com.dev.backend.entity.Person;
import com.dev.backend.repository.PersonClientRepository;
import com.dev.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PersonManagementService {

    @Autowired
    private PersonRepository personRepository;


    @Autowired
    private EmailService emailService;

    public String requestingCode(String email) {
        Person person = personRepository.findByEmail(email);
        person.setCodeRecoveringPassword(getCodeRecoveringPassword(person.getId()));
        person.setDateSendingCode(new Date());
        personRepository.saveAndFlush(person);
        emailService.sendEmailText(person.getEmail(), "Code of recovering password", "Hi, this is your recovering code: " + person.getCodeRecoveringPassword());
        return "Code sent!";
    }

    public String changePassword(Person person) {

        Person personBank = personRepository.findByEmailAndCodeRecoveringPassword(person.getEmail(), person.getCodeRecoveringPassword());
        if (personBank != null){
            Date difference = new Date(new Date().getTime() - personBank.getDateSendingCode().getTime());

        if (difference.getTime() / 1000 < 900) {
            // after adding spring security, it is necessary to add encryption
            personBank.setPassword((person.getPassword()));
            personBank.setCodeRecoveringPassword(null);
            personRepository.saveAndFlush(personBank);
            return "Password has been changed";
        } else {
            return "Time expired, request a new code";
        }
    }else{
        return "User or email not found";
    }

}
    private String getCodeRecoveringPassword(Long id){
        DateFormat format = new SimpleDateFormat("ddMMyyyHHmmssmm");
        return format.format(new Date())+id;
        }
    }
