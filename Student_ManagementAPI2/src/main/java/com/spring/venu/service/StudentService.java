package com.spring.venu.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.venu.entity.Student;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    void deleteStudentById(Integer id);
    Student getStudentById(Integer id);
	
	Student getStudentById(int id);
	Page<Student> getStudentsByPage(Pageable pageable);
	Student updateStudent(int id, Student student);
	Student patchUpdateUserById(Student student, int id);
	List<Student> findByName(String name);

}