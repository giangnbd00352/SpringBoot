package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Entity.Project;
import com.example.Model.createrProject;
import com.example.Service.impl.ProjectServiceImpl;

@Controller

public class ProjectController {
	@Autowired
	private ProjectServiceImpl projectService;
	
	@GetMapping(value= ("/list-project"))
	@ResponseBody
	public List<Project> listProject(Model model)
	{
		
		List<Project> list = projectService.findAll();
		return list;
	}
	
	@PostMapping(value=("/create-project"))
	@ResponseBody
	public createrProject addToProject(@RequestBody Project project) {
		
		projectService.save(project);
		
		createrProject cP =  new createrProject();
		cP.setStatus(true);
		cP.setProjectInfo(project);
		return cP;
		
		
		
	}
}
