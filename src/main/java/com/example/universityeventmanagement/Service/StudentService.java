package com.example.universityeventmanagement.Service;

import com.example.universityeventmanagement.Model.Department;
import com.example.universityeventmanagement.Model.Student;
import com.example.universityeventmanagement.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public String addStudent(Student student) {
        studentRepo.save(student);
        return "Added Successfully";
    }

    public String updateStudentDepartment(int id, Department department) {
        Iterable<Student> students = studentRepo.findAll();
        for(Student student : students){
            if(student.getStudentId()==id){
                student.setDepartment(department);
                studentRepo.save(student);
                return "Student department updated Successfully with : "+id;
            }
        }
        return "Student not found by : "+id;
    }

    public Iterable<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public String deleteStudentById(int id) {
        Optional<Student> student = studentRepo.findById(id);
        if(student.isPresent()){
            studentRepo.deleteById(id);
            return "Student Deleted";
        }
        else{
            return "Student not found";
        }

    }

    public Optional<Student> getStudentById(int id) {
        Optional<Student> student = studentRepo.findById(id);
        return student;
    }
}
