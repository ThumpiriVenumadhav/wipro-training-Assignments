package com.wipro.venu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.venu.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}
