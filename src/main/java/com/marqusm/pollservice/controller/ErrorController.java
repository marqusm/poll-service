package com.marqusm.pollservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@ControllerAdvice
public class ErrorController {

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<Map<String, Object>> processIllegalArgumentException(
      IllegalArgumentException ex, HttpServletRequest request) {
    log.error("processIllegalArgumentException", ex);
    return createResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<Map<String, Object>> processMethodArgumentTypeMismatchException(
      IllegalArgumentException ex, HttpServletRequest request) {
    log.error("processMethodArgumentTypeMismatchException", ex);
    return createResponse(
        HttpStatus.BAD_REQUEST, "Illegal parameter value: " + ex.getMessage(), request);
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<Map<String, Object>> processRuntimeException(
      RuntimeException ex, HttpServletRequest request) {
    log.error("processRuntimeException", ex);
    return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), request);
  }

  private ResponseEntity<Map<String, Object>> createResponse(
      HttpStatus httpStatus, String message, HttpServletRequest httpRequest) {
    val body = new HashMap<String, Object>();
    body.put("timestamp", OffsetDateTime.now());
    body.put("status", httpStatus.value());
    body.put("error", httpStatus.name());
    body.put("message", message);
    body.put("path", httpRequest.getRequestURI());
    return new ResponseEntity<>(body, httpStatus);
  }
}
