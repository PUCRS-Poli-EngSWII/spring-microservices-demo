package br.pucrs.microdemo.microservico1.controller;

import br.pucrs.microdemo.microservico1.domain.User;
import br.pucrs.microdemo.microservico1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class UserController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<User> createStudent(@RequestBody StudentRequest request) {
        User student = studentService.createStudent(request.getNome(), request.getNroMatricula());
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<User> getStudentByMatricula(@PathVariable String matricula) {
        Optional<User> student = studentService.getStudentByMatricula(matricula);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> searchByNome(@RequestParam String nome) {
        List<User> students = studentService.searchStudentByNome(nome);
        return ResponseEntity.ok(students);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllStudents() {
        List<User> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<User> getStudentById(@PathVariable Long id) {
        Optional<User> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateStudent(@PathVariable Long id, @RequestBody StudentRequest request) {
        User student = studentService.updateStudent(id, request.getNome(), request.getNroMatricula());
        if (student != null) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        if (studentService.deleteStudent(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
