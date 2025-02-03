package com.portfolio.demo.repository;

import com.portfolio.demo.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SkillRepository extends JpaRepository<Skill, UUID> {
    // Custom queries can be added here if needed
}
