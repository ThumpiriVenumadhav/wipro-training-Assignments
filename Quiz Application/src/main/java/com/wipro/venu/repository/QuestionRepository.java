package com.wipro.venu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.venu.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	

	@Query(value = "SELECT * FROM question WHERE category = :category AND difficulty = :difficulty ORDER BY RAND() LIMIT 10", nativeQuery = true)
	List<Question> findRandomQuestionByCategoryAndLevel(String category, String difficulty);

}
