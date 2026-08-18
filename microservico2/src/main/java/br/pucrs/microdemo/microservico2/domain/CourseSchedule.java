package br.pucrs.microdemo.microservico2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ForeignKey;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name="COURSE_SCHEDULES")
public class CourseSchedule {
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false, 
        foreignKey = @ForeignKey(name = "fk_course_schedule_course"))
    private Course course;
    
    @Column(nullable = false)
    private String horario; // A, B, C, D, E, F, G

    public CourseSchedule(Course course, String horario) {
        this.course = course;
        this.horario = horario;
    }
}
