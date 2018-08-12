package net.sshplendid.examples.spring.students.controller;

import net.sshplendid.examples.spring.students.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class StudentsController {
    private final List<Student> students = initStudents();

    private List<Student> initStudents() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "John", 15, "male"));
        students.add(new Student(2, "Jane", 19, "female"));
        students.add(new Student(3, "Jameson", 20, "male"));

        return students;
    }

    @GetMapping("/students")
    public List<Student> getStudents(String namelike, Long age) {
        return students.stream()
                       .filter(s -> ( (!Optional.ofNullable(age).isPresent()) || s.getAge() > Optional.ofNullable(age).get())
                        && ( (!Optional.ofNullable(namelike).isPresent()) || s.getName().contains(Optional.ofNullable(namelike).get()))  )
                       .collect(Collectors.toList());
    }

    @PostMapping("/students")
    public Student postStudent(Student student) {
        students.stream()
                .filter(s -> s.getId() == student.getId())
                .findAny()
                .ifPresent(s -> { throw new IllegalArgumentException("There is a student with same ID!");});

        student.setId(students.size()+1);
        students.add(student);

        return student;
    }

    @PatchMapping("/student/{id}")
    public Student patchStudent(String id, Student student) {
        students.stream()
                .filter( s -> s.getId() == Integer.parseInt(id) )
                .forEach( s -> {
                    s.setAge(student.getAge());
                    s.setGender(student.getGender());
                    s.setName(student.getName());
                } );

        return student;
    }
}
