package com.betrybe.alexandria.services.exception;

/**
 * The type Book not found exception.
 */
public class BookNotFoundException extends NotFoundException {
  /**
   * Instantiates a new Book not found exception.
   */
  public BookNotFoundException() {
    super("Livro não encontrado");
  }
}
