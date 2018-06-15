package com.jan.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jan.entity.Project;
import com.jan.service.ProjectService;

@RestController
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@GetMapping(value = "/project/list")
	public List<Project> getList() {
		return projectService.getAllProject();
	}
	
	@GetMapping(value = "/project/{id}")
	public Optional<Project> getProject(@PathVariable("id") int id) {
		return projectService.getProject(id);
	}
	
	@PostMapping(value = "/project/add")
	public void addProject(@RequestBody Project project) {
		projectService.addProject(project);
	}
	
	@PutMapping(value = "/project/{id}")
	public void updateProject(@PathVariable(value = "id") int id,
            @Valid @RequestBody Project project) {
		projectService.updateProject(id, project);
	}
	
	@DeleteMapping(value ="/project/{id}")
	public void deleteProject(@PathVariable(value = "id") int id) {
		projectService.deleteProject(id);
	}
}
