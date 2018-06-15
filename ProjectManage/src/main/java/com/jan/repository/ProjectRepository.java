package com.jan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jan.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{
	
}
