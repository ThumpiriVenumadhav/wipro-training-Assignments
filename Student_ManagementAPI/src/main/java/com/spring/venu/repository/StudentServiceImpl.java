package com.spring.venu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.venu.entity.Student;
import com.spring.venu.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    @Override
    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }
    
    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

	@Override
	public Student getStudentById(int id) {
		
		return studentRepository.findById(id).get();
		
	}

	@Override
	public Page<Student> getStudentsByPage(Pageable pageable) {
		return studentRepository.findAll(pageable);
	}

	@Override
	public Student updateStudent(int id, Student student) {
		Student student1 = getStudentById(id);
		
		student1.setName(student.getName());
		student1.setDob(student.getDob());
		student1.setGender(student.getGender());
		
		return studentRepository.save(student1);
	}

	@Override
	public Student patchUpdateUserById(Student student, int id) {
		
			Student stu = getStudentById(id);
	
		      if(student.getName()!=null)     
		      {
		    	  stu.setName(student.getName());
		      }
		     
		
		return studentRepository.save(stu);
	}

	@Override
	public List<Student> findByName(String name) {
		return studentRepository.findByName(name);
	}

}
