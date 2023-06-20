package dev.diallodev.springbootcicd.student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);
    List<Student> getAllStudents();

    void updateStudent(Long studentId, Student student);

    void deleteStudent(Long studentId);

}