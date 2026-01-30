package com.betrybe.alexandria.advice;

import com.betrybe.alexandria.services.exception.BookNotFoundException;
import com.betrybe.alexandria.services.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type Global controller advice.
 */
@ControllerAdvice
public class GlobalControllerAdvice {
  /**
   * Handle not found exception response entity.
   *
   * @param e the e
   * @return the response entity
   */
  @ExceptionHandler
  public ResponseEntity<String> handleNotFoundException(NotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(e.getMessage());
  }
}
