package com.spring.venu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.venu.entity.Student;
import com.spring.venu.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    // ✅ Show all students on home page
    @GetMapping("/")
    public String viewStudentList(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student_list";
    }

    // ✅ Show add form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "student_form";
    }

    // ✅ Save new or updated student
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/";
    }

    // ✅ Load form with data for update
    @GetMapping("/edit/{rollNo}")
    public String showEditForm(@PathVariable("rollNo") int rollNo, Model model) {
        Student student = studentService.getStudentById(rollNo);
        model.addAttribute("student", student);
        return "student_form";
    }

    // ✅ Delete student
    @GetMapping("/delete/{rollNo}")
    public String deleteStudent(@PathVariable("rollNo") int rollNo) {
        studentService.deleteStudentById(rollNo);
        return "redirect:/";
    }
}
