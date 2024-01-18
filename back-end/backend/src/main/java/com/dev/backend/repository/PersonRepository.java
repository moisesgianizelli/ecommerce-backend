package com.dev.backend.repository;

import com.dev.backend.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByEmail(String email);

    Person findByEmailAndCodeRecoveringPassword(String email, String codeRecoveringPassword);

}
