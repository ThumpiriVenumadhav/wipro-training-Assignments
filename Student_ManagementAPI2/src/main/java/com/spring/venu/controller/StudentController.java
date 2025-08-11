package com.spring.venu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.venu.entity.Student;
import com.spring.venu.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {
	
	

    @Autowired
    private StudentService studentService;
    
    @PostMapping("/create")
    public Student create(
    		@Valid @RequestBody Student student) {
    	return studentService.saveStudent(student);
    }


    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
    	
    return studentService.getStudentById(id);
    		
    }
    
    @GetMapping("/getStudents")
    public List<Student> getStudents(){
    	return studentService.getAllStudents();
    }
    
    @GetMapping("/getpages")
    public Page<Student> getAllStudentsByPage(Pageable pageable){
    	
    	return studentService.getStudentsByPage(pageable);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable int id) {
    	studentService.deleteStudentById(id);
    	
    }
    
    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable int id,@RequestBody Student student) {
    	return studentService.updateStudent(id,student);
    }
    
    @PatchMapping("/patchUpdate/{id}")
    public Student updateByPatch(@RequestBody Student student,@PathVariable int id) {
    	return studentService.patchUpdateUserById(student, id);
    }
    
    @GetMapping("/byName/{name}")
    public List<Student> fingByName(@PathVariable String name){
    	return studentService.findByName(name);
    }
}
