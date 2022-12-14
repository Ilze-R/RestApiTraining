package com.example.springboot.controller;

import com.example.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    //http://localhost:8080/student
//    @GetMapping("student")
//    public Student getStudent(){
//        Student student = new Student(
//                1,
//                "Karlis",
//                "Green"
//        );
//        return student;
//    }

    //example with using ResponseEntity
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                1,
                "Karlis",
                "Green"
        );
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping
    public List<Student>getStudents(){
        List<Student>students = new ArrayList<>();
        students.add(new Student(1, "Olga", "Some"));
        students.add(new Student(2, "Talis", "Lapa"));
        students.add(new Student(3, "John", "Green"));
        students.add(new Student(4, "Tim", "Briii"));
        return students;
    }

    // Spring BOOT REST API with Path Variable
    // {id} - URI template variable
    //http://localhost:8080/students/1
    @GetMapping("/{id}")
    // in case of different naming would be @PathVariable("id") int studentId{
    // return new Student(studentId, ...)
    public Student studentPathVariable(@PathVariable int id){
        return new Student(id, "Tomass", "Today");
    }

    //http://localhost:8080/students/1/tomass/green
    @GetMapping("/{id}/{first-name}/{last-name}")
    public Student studentPathVariableMultiple(@PathVariable ("id") int studentId, @PathVariable("first-name") String firstName,
                                               @PathVariable("last-name") String lastName){
        return new Student(studentId, firstName, lastName);
    }

    // Spring boot REST API with Request Param
    //http://localhost:8080/students/query?id=1
    @GetMapping("/query")
    public Student studentRequestVariable(@RequestParam int id){
        return new Student(id, "Tom", "Red");
    }


    // Spring boot REST API with Request Param
    //http://localhost:8080/students/querymultiple?id=1&firstName=Blue&lastName=Some
    @GetMapping("/querymultiple")
    public Student studentRequestVariableMultiple(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }


    //spring boot REST API that handles HTTP POST Request
    // @RequestBody responsible for retrieving the HTTP request body and automatically converting it into the Java object
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    // Spring boot REST API that handles HTTP PUT Request - updating existing resource
   @PutMapping("/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    // Spring boot REST API that handles HTTP DELETE Request - deleting the existing resource
   @DeleteMapping("/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return "Student deleted successfully!";
    }
}
