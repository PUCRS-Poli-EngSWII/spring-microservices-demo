package br.pucrs.microdemo.microservico3.repository;

import br.pucrs.microdemo.microservico3.domain.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudentId(Long studentId);
    List<Enrollment> findByCourseScheduleId(Long courseScheduleId);
}
