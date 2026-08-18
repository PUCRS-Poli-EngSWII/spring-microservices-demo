package br.pucrs.microdemo.microservico2.repository;

import br.pucrs.microdemo.microservico2.domain.CourseSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseScheduleRepository extends JpaRepository<CourseSchedule, Long> {
    List<CourseSchedule> findByCourseId(Long courseId);
}
