package com.portfolio.demo.service;

import com.portfolio.demo.model.Project;
import com.portfolio.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(UUID uuid) { // Change to UUID
        return projectRepository.findById(uuid).orElse(null);
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(UUID uuid, Project project) { // Change to UUID
        return projectRepository.findById(uuid)
            .map(existingProject -> {
                // Only update fields that are provided
                if (project.getProjectName() != null) {
                    existingProject.setProjectName(project.getProjectName());
                }
                if (project.getDescription() != null) {
                    existingProject.setDescription(project.getDescription());
                }
                return projectRepository.save(existingProject);
            })
            .orElseThrow(() -> new NoSuchElementException("Project not found with uuid: " + uuid));
    }

    public void deleteProject(UUID uuid) { // Change to UUID
        projectRepository.deleteById(uuid);
    }
}
