package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final Map<Long, Faculty> faculties = new HashMap<>();
    private Long generatedFacultyId = 0L;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++generatedFacultyId);
        faculties.put(generatedFacultyId, faculty);
        return faculty;
    }

    public Faculty getFacultyById(Long facultyId) {
        return faculties.get(facultyId);
    }

    public Faculty updateFaculty(Faculty faculty) {
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty deleteFaculty(Long facultyId) {
        return faculties.remove(facultyId);
    }

    public Collection<Faculty> getAllFaculty() {
        return faculties.values();
    }

    public Collection<Faculty> sortAllFacultiesWithColor(String color) {
        return getAllFaculty().stream()
                .filter(faculties -> faculties.getColor().equals(color))
                .collect(Collectors.toList());
    }
}