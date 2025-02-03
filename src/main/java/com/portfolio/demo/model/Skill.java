package com.portfolio.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "skills")
@Data // Lombok annotation for getter, setter, etc.
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto-generate the UUID
    private UUID uuid;

    @Column(name = "skills") // Maps to 'skills' column in DB
    private String skills;

    @Column(name = "description") // Maps to 'description' column in DB
    private String description;
}


