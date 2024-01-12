package com.dev.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "permissionPerson")
@Data
public class PersonPermissions {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idPerson")
    @JsonIgnore
    private Person person;

    @ManyToOne
    @JoinColumn(name = "idPermission")
    private Permissions permissions;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdate;

}
