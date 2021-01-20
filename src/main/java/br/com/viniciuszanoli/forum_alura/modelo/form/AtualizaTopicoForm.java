package br.com.viniciuszanoli.forum_alura.modelo.form;

import br.com.viniciuszanoli.forum_alura.modelo.Topico;
import br.com.viniciuszanoli.forum_alura.repository.TopicoRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizaTopicoForm {

  @NotNull @NotEmpty @Length(min = 5)
  private String titulo;

  @NotNull @NotEmpty @Length(min = 5)
  private String mensagem;

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }

  public Topico atualizar(Long id, TopicoRepository topicoRepository) {
    Topico topico = topicoRepository.getOne(id);
    topico.setTitulo(this.titulo);
    topico.setMensagem(this.mensagem);
    return topico;
  }
}
