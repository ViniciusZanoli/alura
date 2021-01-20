package br.com.viniciuszanoli.forum_alura.config.validacao;

import br.com.viniciuszanoli.forum_alura.config.validacao.dto.ErroDeFormularioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;


/*
* @RestControllerAdvice -> Informa que é uma classe de interceptação
* @ResponseStatus -> altera o status do response para não devolver 200 por conta do tratamento
* @ExceptionHandler -> informa ao spring qual tipo de erro estamos monitorando
* */

@RestControllerAdvice
public class ErroDeValidacaoHandler {

  @Autowired
  private MessageSource messageSource;

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public List<ErroDeFormularioDto> handle(MethodArgumentNotValidException exception){

    List<ErroDeFormularioDto> dto = new ArrayList<>();
    List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

    fieldErrors.forEach(e -> {
      String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
      ErroDeFormularioDto erro = new ErroDeFormularioDto(e.getField(), mensagem);
      dto.add(erro);
    });

    return dto;

  }

}
