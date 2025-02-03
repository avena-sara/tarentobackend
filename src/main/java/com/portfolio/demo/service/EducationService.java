package com.portfolio.demo.service;

import com.portfolio.demo.model.Education;
import com.portfolio.demo.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID; // ✅ Import UUID

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    public List<Education> getAllEducationDetails() {
        return educationRepository.findAll();
    }

    public Education getEducationById(UUID uuid) { // ✅ Changed Long to UUID
        return educationRepository.findById(uuid).orElse(null);
    }

    public Education createEducation(Education education) {
        return educationRepository.save(education);
    }

    public Education updateEducation(UUID uuid, Education education) { // ✅ Changed Long to UUID
        if (educationRepository.existsById(uuid)) {
            education.setUuid(uuid); // ✅ Set UUID instead of ID
            return educationRepository.save(education);
        }
        return null;
    }

    public void deleteEducation(UUID uuid) { // ✅ Changed Long to UUID
        educationRepository.deleteById(uuid);
    }
}
