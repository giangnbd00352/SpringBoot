package com.jan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jan.entity.Project;
import com.jan.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	ProjectRepository projectRepository;

	@Override
	public void addProject(Project project) {
		projectRepository.save(project);
	}

	@Override
	public void updateProject(int id, Project project) {
		Optional<Project> prj = projectRepository.findById(id);
		if (prj.isPresent())
		{
			project.setCodenumber(id);
			projectRepository.save(project);
		}
	}

	@Override
	public List<Project> getAllProject() {
		return projectRepository.findAll();
	}

	@Override
	public void deleteProject(int id) {
		projectRepository.deleteById(id);
	}

	@Override
	public Optional<Project> getProject(int id) {
		return projectRepository.findById(id);
	}

}
