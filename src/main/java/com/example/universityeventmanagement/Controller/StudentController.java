package com.example.universityeventmanagement.Controller;

import com.example.universityeventmanagement.Model.Department;
import com.example.universityeventmanagement.Model.Student;
import com.example.universityeventmanagement.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("addStudent")
    public String addStudent(@RequestBody @Valid Student student){
        return studentService.addStudent(student);
    }

    @PutMapping("updateStudentDepartment/{id}/{department}")
    public String updateStudentDepartment(@PathVariable int id, @PathVariable Department department){
        return studentService.updateStudentDepartment(id,department);
    }

    @GetMapping("getAllStudents")
    public Iterable<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @DeleteMapping("deleteStudent/{id}")
    public String deleteStudentById(@PathVariable int id){
        return studentService.deleteStudentById(id);
    }

    @GetMapping("getStudentById/{id}")
    public Optional<Student> getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }
}
