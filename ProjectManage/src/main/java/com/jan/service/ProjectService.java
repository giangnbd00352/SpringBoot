package com.jan.service;

import java.util.List;
import java.util.Optional;

import com.jan.entity.Project;

public interface ProjectService {
	
	void addProject(Project project);
	void updateProject(int id, Project project);
	Optional<Project> getProject(int id);
	List<Project> getAllProject();
	void deleteProject(int id);
}
