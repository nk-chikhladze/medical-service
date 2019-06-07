package com.project.demo.domains;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@Document
public class MedicalCenter {
	@Id
	private String id;

	private String title;
	private String description;

	private Set<Doctor> doctorSet = new HashSet<>();
}
