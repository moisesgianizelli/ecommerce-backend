package com.dev.backend.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "person")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String password;
    private String address;
    private String cep;
    @ManyToOne
    @JoinColumn(name="idCity")
    private City city;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Setter(value = AccessLevel.NONE)
    private List<PersonPermissions> personPermissions;


    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdate;

    public void setPersonPermissions(List<PersonPermissions> pp){
        for(PersonPermissions p:pp){
            p.setPerson(this);
        }
        this.personPermissions = pp;
    }

}
