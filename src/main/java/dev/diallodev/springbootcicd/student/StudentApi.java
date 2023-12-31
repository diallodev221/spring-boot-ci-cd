package dev.diallodev.springbootcicd.student;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/students")
public interface StudentApi {
    @PostMapping
    ResponseEntity<String> addStudent(@RequestBody Student student);
    @GetMapping
    ResponseEntity<List<Student>> getAllStudents();

    @PutMapping("/{studentId}")
    ResponseEntity<String> updateStudent(@PathVariable Long studentId, @RequestBody Student student);

    @DeleteMapping("/{studentId}")
    ResponseEntity<String> deleteStudent(@PathVariable Long studentId);
}
