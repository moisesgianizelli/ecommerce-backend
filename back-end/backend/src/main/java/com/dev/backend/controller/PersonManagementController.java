package com.dev.backend.controller;

import com.dev.backend.entity.Person;
import com.dev.backend.service.PersonManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person-management")
public class PersonManagementController {

    @Autowired
    private PersonManagementService personManagementService;

    @PostMapping("/password-code")
    public String recoveringCode(@RequestBody Person person){
        return personManagementService.requestingCode(person.getEmail());
    }

    @PostMapping("/password-change")
    public String changeCode(@RequestBody Person person){
        return personManagementService.changePassword(person);
    }


}
