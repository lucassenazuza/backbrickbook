package com.site.backbrickbook.repository;

import com.site.backbrickbook.model.UserSystem;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserSystem, Long> {
    Optional<UserSystem> findByEmail(String email);
}