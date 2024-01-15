package com.dev.backend.repository;

import com.dev.backend.entity.PersonPermissions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionsPersonRepository extends JpaRepository<PersonPermissions, Long> {

}
