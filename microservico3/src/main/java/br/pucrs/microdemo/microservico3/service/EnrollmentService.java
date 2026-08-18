package br.pucrs.microdemo.microservico3.service;

import br.pucrs.microdemo.microservico3.domain.Enrollment;
import br.pucrs.microdemo.microservico3.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {
    
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    public Enrollment createEnrollment(Long studentId, Long courseScheduleId) {
        // Validar se student existe (chamada ao Student Service)
        // Validar se course schedule existe (chamada ao Course Service)
        // Por enquanto, vamos criar o enrollment diretamente
        
        Enrollment enrollment = new Enrollment(studentId, courseScheduleId);
        return enrollmentRepository.save(enrollment);
    }
    
    public Optional<Enrollment> getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id);
    }
    
    public List<Enrollment> getEnrollmentsByStudentId(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }
    
    public List<Enrollment> getEnrollmentsByCourseScheduleId(Long courseScheduleId) {
        return enrollmentRepository.findByCourseScheduleId(courseScheduleId);
    }
    
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }
    
    public boolean deleteEnrollment(Long id) {
        if (enrollmentRepository.existsById(id)) {
            enrollmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
