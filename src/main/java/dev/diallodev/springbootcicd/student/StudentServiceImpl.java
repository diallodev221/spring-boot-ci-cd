package dev.diallodev.springbootcicd.student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void updateStudent(Long studentId, Student student) {
        studentRepository.findById(studentId)
                .map(s -> {
                            s.setName(student.getName());
                            s.setEmail(student.getEmail());
                            s.setAge(student.getAge());
                    return studentRepository.save(s);
                }).orElseThrow(() -> new IllegalArgumentException("Student with id"+ studentId+ " not found"));
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
