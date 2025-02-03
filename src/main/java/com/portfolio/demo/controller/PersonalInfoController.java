package com.portfolio.demo.controller;

import com.portfolio.demo.model.PersonalInfo;
import com.portfolio.demo.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID; // ✅ Import UUID

@CrossOrigin(origins = "http://localhost:5173") 
@RestController
@RequestMapping("/api/personal-info")
public class PersonalInfoController {

    @Autowired
    private PersonalInfoService personalInfoService;

    @GetMapping
    public List<PersonalInfo> getAllPersonalInfo() {
        return personalInfoService.getAllPersonalInfo();
    }

    @GetMapping("/{uuid}") // ✅ Changed Long to UUID
    public PersonalInfo getPersonalInfoById(@PathVariable UUID uuid) { // ✅ Changed Long to UUID
        return personalInfoService.getPersonalInfoById(uuid);
    }

    @PostMapping
    public PersonalInfo createPersonalInfo(@RequestBody PersonalInfo personalInfo) {
        return personalInfoService.createPersonalInfo(personalInfo);
    }

    @PutMapping("/{uuid}") // ✅ Changed Long to UUID
    public PersonalInfo updatePersonalInfo(@PathVariable UUID uuid, @RequestBody PersonalInfo personalInfo) { // ✅ Changed Long to UUID
        return personalInfoService.updatePersonalInfo(uuid, personalInfo);
    }

    @DeleteMapping("/{uuid}") // ✅ Changed Long to UUID
    public void deletePersonalInfo(@PathVariable UUID uuid) { // ✅ Changed Long to UUID
        personalInfoService.deletePersonalInfo(uuid);
    }
}
