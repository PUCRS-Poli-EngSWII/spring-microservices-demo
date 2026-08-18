package br.pucrs.microdemo.microservico2.domain;

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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name="COURSES")
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String codigo;
    
    @Column(nullable = false)
    private String nome;

    public Course(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
}
