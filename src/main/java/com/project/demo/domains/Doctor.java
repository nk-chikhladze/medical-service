package com.project.demo.domains;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Builder
public class Doctor {
	@Id
	private String id;

	private String firstName;
	private String lastName;
	private String number;
	private String workExperience;

	private Specialty specialty	;

}
