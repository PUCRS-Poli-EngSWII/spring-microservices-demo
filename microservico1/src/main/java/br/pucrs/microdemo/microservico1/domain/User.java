package br.pucrs.microdemo.microservico1.domain;

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
@Table(name="STUDENTS")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false, unique = true)
    private String nroMatricula;

    public User(String nome, String nroMatricula) {
        this.nome = nome;
        this.nroMatricula = nroMatricula;
    }
}