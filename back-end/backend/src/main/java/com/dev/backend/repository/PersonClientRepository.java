package com.dev.backend.repository;

import com.dev.backend.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonClientRepository extends JpaRepository<Person, Long> {
}
