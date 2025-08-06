package com.Admin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String email;
	    private String phone;
	    private String dob;
	    private String address;
	    private String fatherName;
	    private String motherName;
	    private String linkedinUrl;
	    private String githubUrl;
	    private String portfolioUrl;
	    @Column(length = 1000)
	    private String professionalObjective;
	    private String education;
	    private String skills;
	    private String workExperience;
	    private String projects;
	    private String certifications;
	    private String achievements;
	    private String languages;
	    private String hobbies;
	    @Column(name = "`references`")
	    private String references;
	    @ManyToOne
	    @JoinColumn(name = "admin_id")
	    private AdminEntity admin;
	}