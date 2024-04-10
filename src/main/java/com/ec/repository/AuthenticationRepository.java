package com.ec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.entity.Authentication;

public interface AuthenticationRepository extends JpaRepository<Authentication, String> {

}
