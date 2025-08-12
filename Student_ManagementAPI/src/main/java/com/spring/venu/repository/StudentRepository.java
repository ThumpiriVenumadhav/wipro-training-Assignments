package com.spring.venu.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.venu.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByName(String name);
}
