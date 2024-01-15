package com.dev.backend.dto;

import com.dev.backend.entity.City;
import com.dev.backend.entity.Person;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class PersonClientRequestDTO {
    private String name;
    private String cpf;
    private String email;
    private String address;
    private String cep;
    private City city;

    public Person converter(PersonClientRequestDTO personClientRequestDTO){
       Person person = new Person();
        BeanUtils.copyProperties(personClientRequestDTO, person);
        return person;
    }
}
