package com.wipro.venu.entity;

import com.wipro.venu.enums.Catogory;
import com.wipro.venu.enums.Difficult;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	 @NotNull(message="question title  is required")
	private String questionTitle;
	@Column
	 @NotNull(message="option1 is required")
	private String option1;
	@Column
	 @NotNull(message="option2 is required")
	private String option2;
	@Column
	 @NotNull(message="option3 is required")
	private String option3;
	@Column
	 @NotNull(message="option4 is required")
	private String option4;
	@Column
	 @NotNull(message="correct answer is required")
	private String correctAnswer;
	@Column
	 @Enumerated(EnumType.STRING)
	 @NotNull(message="difficulty is required")
	private Difficult difficulty;
	@Column
	 @Enumerated(EnumType.STRING)
	 @NotNull(message="category is required")
	private Catogory category;

}
