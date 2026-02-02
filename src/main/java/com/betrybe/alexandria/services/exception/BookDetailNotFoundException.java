package com.betrybe.alexandria.services.exception;

/**
 * The type Book detail not found exception.
 */
public class BookDetailNotFoundException extends NotFoundException {
  /**
   * Instantiates a new Book detail not found exception.
   */
  public BookDetailNotFoundException() {
    super("Detalhes do livro não encontrados!");
  }
}
