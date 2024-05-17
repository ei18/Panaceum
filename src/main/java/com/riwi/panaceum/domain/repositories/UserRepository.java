package com.riwi.panaceum.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.panaceum.domain.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    public Optional<User> findByUserEmail(String email);
}

