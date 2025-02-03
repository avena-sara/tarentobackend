package com.portfolio.demo.controller;

import com.portfolio.demo.model.Skill;
import com.portfolio.demo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/skills")
public class SkillController {

    @Autowired
    private SkillService skillService;

    // Get all skills
    @GetMapping
    public List<Skill> getAllSkills() {
        return skillService.getAllSkills();
    }

    // Get a skill by UUID
    @GetMapping("/{uuid}")
    public Optional<Skill> getSkillById(@PathVariable UUID uuid) {
        return skillService.getSkillById(uuid);
    }

    // Add a new skill
    @PostMapping
    public Skill addSkill(@RequestBody Skill skill) {
        return skillService.saveSkill(skill);
    }

    // Delete a skill by UUID
    @DeleteMapping("/{uuid}")
    public void deleteSkill(@PathVariable UUID uuid) {
        skillService.deleteSkill(uuid);
    }

    // Update an existing skill by UUID
    @PutMapping("/{uuid}")
    public ResponseEntity<Skill> updateSkill(@PathVariable UUID uuid, @RequestBody Skill updatedSkill) {
        try {
            Skill updated = skillService.updateSkill(uuid, updatedSkill);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if not found
        }
    }
}
