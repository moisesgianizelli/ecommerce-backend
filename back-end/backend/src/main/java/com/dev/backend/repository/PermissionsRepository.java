package com.dev.backend.repository;

import com.dev.backend.entity.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionsRepository extends JpaRepository<Permissions, Long> {
}
