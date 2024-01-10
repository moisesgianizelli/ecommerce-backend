package com.dev.backend.service;

import com.dev.backend.entity.Permissions;
import com.dev.backend.repository.PermissionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PermissionsService {

    @Autowired
    private PermissionsRepository permissionsRepository;

    public List<Permissions> searchAll(){
        return permissionsRepository.findAll();

    }

    public Permissions insert(Permissions permissions){
        permissions.setDateCreation(new Date());
        Permissions permissionsNew = permissionsRepository.saveAndFlush(permissions);
        return permissionsNew;
    }

    public Permissions modify(Permissions permissions){
        permissions.setDateUpdate(new Date());
        return permissionsRepository.saveAndFlush(permissions);
    }

    public void delete(Long id){
        Permissions permissions = permissionsRepository.findById(id).get();
        permissionsRepository.delete(permissions);
    }
}
