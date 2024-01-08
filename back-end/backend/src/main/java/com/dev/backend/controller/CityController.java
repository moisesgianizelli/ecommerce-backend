package com.dev.backend.controller;

import com.dev.backend.entity.City;
import com.dev.backend.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/")
    public List<City> searchAll(){
        return cityService.searchAll();
    }

    @PostMapping("/")
    public City insert(@RequestBody City city){
        return cityService.insert(city);
    }

    @PutMapping("/")
    public City modify(@RequestBody City city){
        return cityService.modify(city);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        cityService.delete(id);
        return ResponseEntity.ok().build();
    }
}
