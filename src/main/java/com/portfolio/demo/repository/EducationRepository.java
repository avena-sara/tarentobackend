package com.portfolio.demo.repository;

import com.portfolio.demo.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EducationRepository extends JpaRepository<Education, UUID> { // ✅ Use UUID here
}
