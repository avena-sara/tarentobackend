package com.portfolio.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID; // ✅ Import UUID

@Entity
@Table(name = "personal_info")
@Data // Lombok annotation to generate getters, setters, equals, hashcode, toString
public class PersonalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto-generate the UUID
    private UUID uuid; // ✅ Changed from Long id to UUID

    @Column(name = "name")
    private String name; // Maps to 'name' column in DB

    @Column(name = "photo_url")
    private String photoUrl; // Maps to 'photo_url' column in DB

    @Column(name = "email")
    private String email; // Maps to 'email' column in DB

    @Column(name = "phone_number")
    private String phoneNumber; // Maps to 'phone_number' column in DB
}
