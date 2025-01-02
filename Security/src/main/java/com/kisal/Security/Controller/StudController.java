package com.kisal.Security.Controller;

import com.kisal.Security.Model.Student;
import com.kisal.Security.Service.StudentService;
//import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import java.util.ArrayList;
import java.util.List;


@RestController
public class StudController {

    @Autowired
    private StudentService studService;

//    private List<Student> students = new ArrayList<>(List.of(
//            new Student("1", "Kisal", "1", 22),
//            new Student("2", "Kisal2", "2", 22),
//            new Student("3", "Kisal3", "3", 22)
//
//    ));

//    @PostMapping("/addStud")
//    public ResponseEntity<?> addStudent(@RequestBody Student student){
//        return ResponseEntity.ok(students.add(student));
//
//    }
//
//    @GetMapping("/getStuds")
//    public ResponseEntity<List<Student>> getStudents(){
//        return ResponseEntity.ok(students);
//    }

    @PostMapping("/addStud")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        return ResponseEntity.ok(studService.saveStudent(student));

    }

    @GetMapping("/getStuds")
    public ResponseEntity<List<Student>> getStudents(){

        return ResponseEntity.ok(studService.fetchStudents());
    }

    //getting token

    // @GetMapping("/token")
    // public CsrfToken getToken(HttpServletRequest req){
    //     return (CsrfToken) req.getAttribute("_csrf");
    //}

}
