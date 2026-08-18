package br.pucrs.microdemo.microservico2.service;

import br.pucrs.microdemo.microservico2.domain.Course;
import br.pucrs.microdemo.microservico2.domain.CourseSchedule;
import br.pucrs.microdemo.microservico2.repository.CourseRepository;
import br.pucrs.microdemo.microservico2.repository.CourseScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    
    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private CourseScheduleRepository courseScheduleRepository;
    
    // Course operations
    public Course createCourse(String codigo, String nome) {
        Course course = new Course(codigo, nome);
        return courseRepository.save(course);
    }
    
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }
    
    public Optional<Course> getCourseByCodigo(String codigo) {
        return courseRepository.findByCodigo(codigo);
    }
    
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    
    public Course updateCourse(Long id, String codigo, String nome) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            Course c = course.get();
            c.setCodigo(codigo);
            c.setNome(nome);
            return courseRepository.save(c);
        }
        return null;
    }
    
    public boolean deleteCourse(Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    // CourseSchedule operations
    public CourseSchedule addSchedule(Long courseId, String horario) {
        Optional<Course> course = courseRepository.findById(courseId);
        if (course.isPresent()) {
            CourseSchedule schedule = new CourseSchedule(course.get(), horario);
            return courseScheduleRepository.save(schedule);
        }
        return null;
    }
    
    public List<CourseSchedule> getCourseSchedules(Long courseId) {
        return courseScheduleRepository.findByCourseId(courseId);
    }
    
    public Optional<CourseSchedule> getScheduleById(Long id) {
        return courseScheduleRepository.findById(id);
    }
    
    public List<CourseSchedule> getAllSchedules() {
        return courseScheduleRepository.findAll();
    }
    
    public boolean deleteSchedule(Long id) {
        if (courseScheduleRepository.existsById(id)) {
            courseScheduleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
