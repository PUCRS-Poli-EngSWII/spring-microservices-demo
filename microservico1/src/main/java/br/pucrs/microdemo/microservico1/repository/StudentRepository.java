package br.pucrs.microdemo.microservico1.repository;

import br.pucrs.microdemo.microservico1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByNroMatricula(String nroMatricula);
    
    @Query("SELECT s FROM User s WHERE LOWER(s.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<User> searchByNome(@Param("nome") String nome);
}
