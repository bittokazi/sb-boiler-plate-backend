package com.backend.boiler.plate.modules.base.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findOneByEmail(String email);
}
