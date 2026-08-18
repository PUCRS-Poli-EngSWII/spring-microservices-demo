package br.pucrs.microdemo.microservico2.repository;

import br.pucrs.microdemo.microservico2.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByCodigo(String codigo);
}
