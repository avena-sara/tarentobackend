package com.portfolio.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "projects")
@Data // Lombok annotation to generate getters, setters, equals, hashcode, toString
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // This will generate a UUID automatically
    private UUID uuid; // Changed from Long id to UUID as the primary key

    private String projectName; // Maps to 'project_name' column in DB
    private String description; // Maps to 'project_description' column in DB
    private String proimages;
}
