package com.marx.instrutor.pagamento.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

  @ExceptionHandler(SaldoIndisponivelException.class)
  public void handleCustomException(HttpServletResponse res, SaldoIndisponivelException ex) throws IOException {
    res.sendError(ex.getHttpStatus().value(), ex.getMessage());
  }
}