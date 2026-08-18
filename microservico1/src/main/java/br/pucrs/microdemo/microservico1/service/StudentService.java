package br.pucrs.microdemo.microservico1.service;

import br.pucrs.microdemo.microservico1.domain.User;
import br.pucrs.microdemo.microservico1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    public User createStudent(String nome, String nroMatricula) {
        User student = new User(nome, nroMatricula);
        return studentRepository.save(student);
    }
    
    public Optional<User> getStudentByMatricula(String nroMatricula) {
        return studentRepository.findByNroMatricula(nroMatricula);
    }
    
    public List<User> searchStudentByNome(String nome) {
        return studentRepository.searchByNome(nome);
    }
    
    public List<User> getAllStudents() {
        return studentRepository.findAll();
    }
    
    public Optional<User> getStudentById(Long id) {
        return studentRepository.findById(id);
    }
    
    public User updateStudent(Long id, String nome, String nroMatricula) {
        Optional<User> student = studentRepository.findById(id);
        if (student.isPresent()) {
            User s = student.get();
            s.setNome(nome);
            s.setNroMatricula(nroMatricula);
            return studentRepository.save(s);
        }
        return null;
    }
    
    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
