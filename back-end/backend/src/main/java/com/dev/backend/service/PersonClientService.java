package com.dev.backend.service;

import com.dev.backend.dto.PersonClientRequestDTO;
import com.dev.backend.entity.Person;
import com.dev.backend.repository.PermissionsRepository;
import com.dev.backend.repository.PersonClientRepository;
import com.dev.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersonClientService {

    @Autowired
    private PersonClientRepository personRepository;

    @Autowired
    private PermissionsPersonService permissionsPersonService;

    @Autowired
    private EmailService emailService;

    public Person register(PersonClientRequestDTO personClientRequestDTO){
        Person person = new PersonClientRequestDTO().converter(personClientRequestDTO);
        person.setDateCreation(new Date());
        Person personNew = personRepository.saveAndFlush(person);
        permissionsPersonService.linkPersonPermissionsClient(personNew);
        emailService.sendEmailText(personNew.getEmail(),"Register in the store", "The register was successfully done");
        return personNew;
    }


}
