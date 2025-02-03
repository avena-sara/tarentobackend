package com.portfolio.demo.controller;

import com.portfolio.demo.model.Project;
import com.portfolio.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:5173") 
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }
    
    @GetMapping("/{uuid}")
    public Project getProjectById(@PathVariable UUID uuid) { // Change to UUID
        return projectService.getProjectById(uuid);
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @PutMapping("/{uuid}")
    public Project updateProject(@PathVariable UUID uuid, @RequestBody Project project) { // Change to UUID
        return projectService.updateProject(uuid, project);
    }

    @DeleteMapping("/{uuid}")
    public void deleteProject(@PathVariable UUID uuid) { // Change to UUID
        projectService.deleteProject(uuid);
    }
}
