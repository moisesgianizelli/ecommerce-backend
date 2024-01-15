package com.dev.backend.controller;

import com.dev.backend.dto.PersonClientRequestDTO;
import com.dev.backend.entity.Person;
import com.dev.backend.service.PersonClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class PersonClientController {

    @Autowired
    private PersonClientService personService;

    @PostMapping("/")
    public Person insert(@RequestBody PersonClientRequestDTO personClientRequestDTO){
        return personService.register(personClientRequestDTO);
    }


}
