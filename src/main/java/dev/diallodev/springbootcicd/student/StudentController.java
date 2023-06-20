package dev.diallodev.springbootcicd.student;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@AllArgsConstructor
@RestController
public class StudentController implements StudentApi {

    private final StudentService studentService;

    @Override
    public ResponseEntity<String> addStudent(Student student) {
        var resource  = studentService.addStudent(student);
        var resourceLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{studentId}")
                .buildAndExpand(resource.getStudentId())
                .toUri();
        return ResponseEntity.created(resourceLocation).build();
    }

    @Override
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @Override
    public ResponseEntity<String> updateStudent(Long studentId, Student student) {
        studentService.updateStudent(studentId, student);
        return ResponseEntity.ok("Student with id: "+ studentId+ " updated successfully!");
    }

    @Override
    public ResponseEntity<String> deleteStudent(Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student with id "+ studentId+ " was deleted");
    }
}
