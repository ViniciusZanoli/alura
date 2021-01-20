package br.com.viniciuszanoli.forum_alura.repository;

import br.com.viniciuszanoli.forum_alura.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
