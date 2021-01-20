package br.com.viniciuszanoli.forum_alura.controller;

import br.com.viniciuszanoli.forum_alura.modelo.Topico;
import br.com.viniciuszanoli.forum_alura.modelo.dto.DetalhesDoTopicoDto;
import br.com.viniciuszanoli.forum_alura.modelo.dto.TopicoDto;
import br.com.viniciuszanoli.forum_alura.modelo.form.AtualizaTopicoForm;
import br.com.viniciuszanoli.forum_alura.modelo.form.TopicoForm;
import br.com.viniciuszanoli.forum_alura.repository.CursoRepository;
import br.com.viniciuszanoli.forum_alura.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

  @Autowired
  private TopicoRepository topicoRepository;

  @Autowired
  private CursoRepository cursoRepository;

  @GetMapping
  public List<TopicoDto> lista() {
    List<Topico> topicos = topicoRepository.findAll();
    return TopicoDto.converter(topicos);
  }

  @GetMapping("/{id}")
  public ResponseEntity<DetalhesDoTopicoDto> detalhar(@PathVariable Long id) {
    Optional<Topico> topico = topicoRepository.findById(id);
    return topico.map(value -> ResponseEntity.
            ok(new DetalhesDoTopicoDto(value))).
            orElseGet(() -> ResponseEntity.notFound().build());
  }

  @Transactional
  @PostMapping
  public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
    Topico topico = form.converter(cursoRepository);
    topicoRepository.save(topico);

    URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

    return ResponseEntity.created(uri).body(new TopicoDto(topico));
  }

  @Transactional
  @PutMapping("/{id}")
  public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizaTopicoForm form) {
    Optional<Topico> optional = topicoRepository.findById(id);
    if (optional.isPresent()) {
      Topico topico = form.atualizar(id, topicoRepository);
      return ResponseEntity.ok(new TopicoDto(topico));
    }
    return ResponseEntity.notFound().build();
  }

  @Transactional
  @DeleteMapping("/{id}")
  public ResponseEntity<?> deletar(@PathVariable Long id) {
    Optional<Topico> optional = topicoRepository.findById(id);
    if (optional.isPresent()) {
      topicoRepository.deleteById(id);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }
}
