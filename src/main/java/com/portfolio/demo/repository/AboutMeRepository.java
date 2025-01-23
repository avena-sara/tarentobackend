package com.portfolio.demo.repository;

import com.portfolio.demo.model.AboutMe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutMeRepository extends JpaRepository<AboutMe, Long> {
    // Custom queries can be added here if needed
}
