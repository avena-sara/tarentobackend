package com.portfolio.demo.service;

import com.portfolio.demo.model.Skill;
import com.portfolio.demo.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    // Save a new skill
    public Skill saveSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    // Get all skills
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    // Get a skill by UUID
    public Optional<Skill> getSkillById(UUID uuid) {
        return skillRepository.findById(uuid);
    }

    // Delete a skill by UUID
    public void deleteSkill(UUID uuid) {
        skillRepository.deleteById(uuid);
    }

    // Update an existing skill
    public Skill updateSkill(UUID uuid, Skill updatedSkill) {
        Optional<Skill> existingSkill = skillRepository.findById(uuid);

        if (existingSkill.isPresent()) {
            Skill skill = existingSkill.get();
            // Update fields based on the request
            skill.setSkills(updatedSkill.getSkills());
            skill.setDescription(updatedSkill.getDescription());
            return skillRepository.save(skill); // Save the updated skill
        } else {
            // Handle the case where the skill is not found (you can throw an exception or return null)
            throw new RuntimeException("Skill not found with UUID: " + uuid);
        }
    }
}
