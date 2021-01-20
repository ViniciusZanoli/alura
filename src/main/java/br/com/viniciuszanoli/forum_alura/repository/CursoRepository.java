package br.com.viniciuszanoli.forum_alura.repository;


import br.com.viniciuszanoli.forum_alura.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
  Curso findByNome(String nome);
}
