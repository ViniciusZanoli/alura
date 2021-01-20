package br.com.viniciuszanoli.forum_alura.config.validacao.dto;

public class ErroDeFormularioDto {
  private String campo;
  private String erro;

  public ErroDeFormularioDto(String campo, String mensagemErro) {
    this.campo = campo;
    this.erro = mensagemErro;
  }

  public String getCampo() {
    return campo;
  }

  public String getMensagemErro() {
    return erro;
  }
}
