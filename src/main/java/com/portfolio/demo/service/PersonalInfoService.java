package com.portfolio.demo.service;

import com.portfolio.demo.model.PersonalInfo;
import com.portfolio.demo.repository.PersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID; // ✅ Import UUID

@Service
public class PersonalInfoService {

    @Autowired
    private PersonalInfoRepository personalInfoRepository;

    public List<PersonalInfo> getAllPersonalInfo() {
        return personalInfoRepository.findAll();
    }

    public PersonalInfo getPersonalInfoById(UUID uuid) { // ✅ Changed Long to UUID
        return personalInfoRepository.findById(uuid).orElse(null);
    }

    public PersonalInfo createPersonalInfo(PersonalInfo personalInfo) {
        return personalInfoRepository.save(personalInfo);
    }

    public PersonalInfo updatePersonalInfo(UUID uuid, PersonalInfo personalInfo) { // ✅ Changed Long to UUID
        if (personalInfoRepository.existsById(uuid)) {
            personalInfo.setUuid(uuid); // ✅ Set UUID instead of ID
            return personalInfoRepository.save(personalInfo);
        }
        return null;
    }

    public void deletePersonalInfo(UUID uuid) { // ✅ Changed Long to UUID
        personalInfoRepository.deleteById(uuid);
    }
}
