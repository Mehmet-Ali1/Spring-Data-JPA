package com.mehmetali.services.impl;

import com.mehmetali.entites.Student;
import com.mehmetali.repository.StudentRepository;
import com.mehmetali.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> optinal = studentRepository.findById(id);
        if (optinal.isPresent()) {
            return optinal.get();
        }
        return null;
    }


    @Override
    public void deleteStudent(Long id) {
        Student dbStudent = getStudentById(id);

        if (dbStudent != null) {
            studentRepository.delete(dbStudent);
        } else {
            System.out.println("kayit bulunamadi:");
        }

    }

    @Override
    public Student updateStudent(Long id, Student updateStudent) {
        Student dbStudent = new Student();
        if (dbStudent != null) {
            dbStudent.setFirstName(updateStudent.getFirstName());
            dbStudent.setLastName(updateStudent.getLastName());
            dbStudent.setBirthOfDate(updateStudent.getBirthOfDate());
            return studentRepository.save(dbStudent);
        }
        return null;
    }
}
