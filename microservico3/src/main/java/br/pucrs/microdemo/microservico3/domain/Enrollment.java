package br.pucrs.microdemo.microservico3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name="ENROLLMENTS")
public class Enrollment {
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false)
    private Long studentId;
    
    @Column(nullable = false)
    private Long courseScheduleId;
    
    @Column(nullable = false)
    private LocalDateTime dataMatricula;

    public Enrollment(Long studentId, Long courseScheduleId) {
        this.studentId = studentId;
        this.courseScheduleId = courseScheduleId;
        this.dataMatricula = LocalDateTime.now();
    }
}
