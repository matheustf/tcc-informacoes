package com.puc.tcc.informacoes.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.puc.tcc.informacoes.exceptions.ConsumerAvaliacaoException;
import com.puc.tcc.informacoes.exceptions.ConsumerEntregaException;
import com.puc.tcc.informacoes.exceptions.ConsumerPedidoException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionAdvice {
	
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Base> processParameterizedValidationError(Exception ex) {
		log.error(ex.getMessage(),ex);
		return processError(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Base> processParameterizedValidationError(MethodArgumentNotValidException ex) {
		log.error(ex.getMessage(),ex);
		return processError(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ResponseBody
	@ExceptionHandler(ConsumerEntregaException.class)
	public ResponseEntity<Base> processParameterizedValidationError(ConsumerEntregaException ex) {
		log.error(ex.getMessage(),ex);
		return processError(ex.getMessage(),ex.getStatusCode());
	}
	
	@ResponseBody
	@ExceptionHandler(ConsumerAvaliacaoException.class)
	public ResponseEntity<Base> processParameterizedValidationError(ConsumerAvaliacaoException ex) {
		log.error(ex.getMessage(),ex);
		return processError(ex.getMessage(),ex.getStatusCode());
	}

	@ResponseBody
	@ExceptionHandler(ConsumerPedidoException.class)
	public ResponseEntity<Base> processParameterizedValidationError(ConsumerPedidoException ex) {
		log.error(ex.getMessage(),ex);
		return processError(ex.getMessage(),ex.getStatusCode());
	}
	
	private ResponseEntity<Base> processError(String error,HttpStatus headerStatus) {
		Base baseDTO = new Base(headerStatus.value(),error);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<>(baseDTO,httpHeaders,headerStatus);
	}
}