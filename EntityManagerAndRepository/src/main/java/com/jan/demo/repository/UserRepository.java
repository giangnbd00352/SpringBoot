package com.jan.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jan.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
}
