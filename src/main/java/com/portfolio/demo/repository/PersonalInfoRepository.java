package com.portfolio.demo.repository;

import com.portfolio.demo.model.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, UUID> { // ✅ Use UUID here
}
