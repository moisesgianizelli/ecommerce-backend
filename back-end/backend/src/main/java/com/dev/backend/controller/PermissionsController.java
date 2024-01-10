package com.dev.backend.controller;


import com.dev.backend.entity.Permissions;
import com.dev.backend.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/permissions")
public class PermissionsController {

    @Autowired
    private PermissionsService permissionsService;

    @GetMapping("/")
    public List<Permissions> searchAll(){
        return permissionsService.searchAll();
    }

    @PostMapping("/")
    public Permissions insert(@RequestBody Permissions permissions){
        return permissionsService.insert(permissions);
    }

    @PutMapping("/")
    public Permissions modify(@RequestBody Permissions permissions){
        return permissionsService.modify(permissions);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        permissionsService.delete(id);
        return ResponseEntity.ok().build();
    }
}
