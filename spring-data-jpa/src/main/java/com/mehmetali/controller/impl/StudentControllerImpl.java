package com.mehmetali.controller.impl;

import com.mehmetali.controller.IStudentController;
import com.mehmetali.entites.Student;
import com.mehmetali.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController {

    @Autowired
    private IStudentService studentService;


   @PostMapping (path = "/save")
    @Override
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
@GetMapping(path = "/list")
    @Override
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public Student getStudentsById(@PathVariable(name = "id") Long id) {
        return studentService.getStudentById(id);
    }
@DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteStudent(@PathVariable(name = "id") Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public Student updateStudent(@PathVariable(name = "id") Long id,
                                 @RequestBody Student updateStudent) {
        return studentService.updateStudent(id,updateStudent);
    }
}
