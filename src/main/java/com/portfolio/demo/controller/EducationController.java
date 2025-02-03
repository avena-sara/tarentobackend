package com.portfolio.demo.controller;

import com.portfolio.demo.model.Education;
import com.portfolio.demo.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID; // ✅ Import UUID

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/education")
public class EducationController {

    @Autowired
    private EducationService educationService;

    @GetMapping
    public List<Education> getAllEducationDetails() {
        return educationService.getAllEducationDetails();
    }

    @GetMapping("/{uuid}") // ✅ Changed {id} to {uuid}
    public Education getEducationById(@PathVariable UUID uuid) { // ✅ Changed Long to UUID
        return educationService.getEducationById(uuid);
    }

    @PostMapping
    public Education createEducation(@RequestBody Education education) {
        return educationService.createEducation(education);
    }

    @PutMapping("/{uuid}") // ✅ Changed {id} to {uuid}
    public Education updateEducation(@PathVariable UUID uuid, @RequestBody Education education) { // ✅ Changed Long to UUID
        return educationService.updateEducation(uuid, education);
    }

    @DeleteMapping("/{uuid}") // ✅ Changed {id} to {uuid}
    public void deleteEducation(@PathVariable UUID uuid) { // ✅ Changed Long to UUID
        educationService.deleteEducation(uuid);
    }
}
