package br.pucrs.microdemo.microservico2.controller;

import br.pucrs.microdemo.microservico2.domain.Course;
import br.pucrs.microdemo.microservico2.domain.CourseSchedule;
import br.pucrs.microdemo.microservico2.service.CourseService;
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
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CitationController {
    
    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody CourseRequest request) {
        Course course = courseService.createCourse(request.getCodigo(), request.getNome());
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Optional<Course> course = courseService.getCourseById(id);
        return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<Course> getCourseByCodigo(@PathVariable String codigo) {
        Optional<Course> course = courseService.getCourseByCodigo(codigo);
        return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody CourseRequest request) {
        Course course = courseService.updateCourse(id, request.getCodigo(), request.getNome());
        if (course != null) {
            return ResponseEntity.ok(course);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        if (courseService.deleteCourse(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{courseId}/horarios")
    public ResponseEntity<CourseSchedule> addSchedule(@PathVariable Long courseId, @RequestBody ScheduleRequest request) {
        CourseSchedule schedule = courseService.addSchedule(courseId, request.getHorario());
        if (schedule != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(schedule);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{courseId}/horarios")
    public ResponseEntity<List<CourseSchedule>> getCourseSchedules(@PathVariable Long courseId) {
        List<CourseSchedule> schedules = courseService.getCourseSchedules(courseId);
        return ResponseEntity.ok(schedules);
    }

    @GetMapping("/horarios/{scheduleId}")
    public ResponseEntity<CourseSchedule> getScheduleById(@PathVariable Long scheduleId) {
        Optional<CourseSchedule> schedule = courseService.getScheduleById(scheduleId);
        return schedule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/horarios/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long scheduleId) {
        if (courseService.deleteSchedule(scheduleId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
