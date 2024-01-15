package com.dev.backend.service;

import com.dev.backend.entity.Permissions;
import com.dev.backend.entity.Person;
import com.dev.backend.entity.PersonPermissions;
import com.dev.backend.repository.PermissionsPersonRepository;
import com.dev.backend.repository.PermissionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PermissionsPersonService {

    @Autowired
    private PermissionsPersonRepository permissionsPersonRepository;

    @Autowired
    private PermissionsRepository permissionsRepository;

    public void linkPersonPermissionsClient(Person person){
        List<Permissions> listPermission = permissionsRepository.findByName("client");
        if(listPermission.size()>0){
            PersonPermissions personPermissions = new PersonPermissions();
            personPermissions.setPerson(person);
            personPermissions.setPermissions(listPermission.get(0));
            personPermissions.setDateCreation(new Date());
            permissionsPersonRepository.saveAndFlush(personPermissions);
        }
    }

}
