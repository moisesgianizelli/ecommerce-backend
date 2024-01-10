package com.dev.backend.service;

import com.dev.backend.entity.Brand;
import com.dev.backend.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> searchAll(){
        return brandRepository.findAll();
    }

    public Brand insert(Brand brand){
        brand.setDateCreation(new Date());
        Brand newBrand = brandRepository.saveAndFlush(brand);
        return newBrand;
    }

    public Brand modify(Brand brand){
        brand.setDateUpdate(new Date());
        return brandRepository.saveAndFlush(brand);
    }

    public void delete (Long id){
        Brand brand = brandRepository.findById(id).get();
        brandRepository.delete(brand);
    }

}
