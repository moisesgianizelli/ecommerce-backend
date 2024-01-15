package com.dev.backend.repository;

import com.dev.backend.entity.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionsRepository extends JpaRepository<Permissions, Long> {

    List<Permissions> findByName(String name);
}
