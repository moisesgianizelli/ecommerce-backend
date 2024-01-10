package com.dev.backend.controller;

import com.dev.backend.entity.Person;
import com.dev.backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public List<Person> searchAll(){
        return personService.searchAll();
    }

    @PostMapping("/")
    public Person insert(@RequestBody Person person){
        return personService.insert(person);
    }

    @PutMapping("/")
    public Person modify(@RequestBody Person person){
        return personService.modify(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")Long id){
        personService.delete(id);
        return ResponseEntity.ok().build();
    }

}
