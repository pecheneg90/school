package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final Map<Long, Student> students = new HashMap<>();
    private Long generatedStudentId = 0L;

    public Student createStudent(Student student) {
        student.setId(++generatedStudentId);
        students.put(generatedStudentId, student);
        return student;
    }

    public Student getStudentById(Long studentId) {
        return students.get(studentId);
    }

    public Student updateStudent(Student student) {
        students.put(student.getId(), student);
        return student;
    }

    public Student deleteStudent(Long studentId) {
        return students.remove(studentId);
    }

    public Collection<Student> getAllStudents() {
        return students.values();
    }

    public Collection<Student> sortAllStudentsWithAge(int age) {
        return getAllStudents().stream()
                .filter(students -> students.getAge() == age)
                .collect(Collectors.toList());
    }
}