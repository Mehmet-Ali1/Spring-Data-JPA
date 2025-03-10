package com.mehmetali.controller;

import com.mehmetali.entites.Student;

import java.util.List;

public interface IStudentController {

    public Student saveStudent(Student student);

    public List<Student> getAllStudents();

    public Student getStudentsById(Long id);

    public void deleteStudent(Long id);

    public Student updateStudent(Long id,Student updateStudent);
}
