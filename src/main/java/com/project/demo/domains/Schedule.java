package com.project.demo.domains;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Builder
@Document
public class Schedule {
	@Id
	private String id;

	private Date date;

	private String user_id;
	private String doctor_id;
}
