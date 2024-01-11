package com.dev.backend.service;

import com.dev.backend.entity.Product;
import com.dev.backend.entity.ProductImages;
import com.dev.backend.repository.ProductImagesRepository;
import com.dev.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class ProductImagesService {

    @Autowired
    private ProductImagesRepository productImagesRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<ProductImages> searchAll(){
        return productImagesRepository.findAll();
    }

    public ProductImages insert (Long idProduct, MultipartFile file){
        Product product = productRepository.findById(idProduct).get();
        ProductImages productImages = new ProductImages();

        try{
            if(!file.isEmpty()){
                byte[] bytes = file.getBytes();
                String nameImage = String.valueOf(product.getId()) + file.getOriginalFilename();
                    Path path = Paths.get("C:/images/" + nameImage);
                Files.write(path, bytes);
                productImages.setName(nameImage);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        productImages.setProduct(product);
        productImages.setDateCreation(new Date());
            productImages = productImagesRepository.saveAndFlush(productImages);
        return productImages;
    }

    public ProductImages modify(ProductImages productImages) {
        productImages.setDateUpdate(new Date());
        return productImagesRepository.saveAndFlush(productImages);
    }

    public void delete(Long id) {
        ProductImages productImages = productImagesRepository.findById(id).get();
        productImagesRepository.delete(productImages);
    }
}