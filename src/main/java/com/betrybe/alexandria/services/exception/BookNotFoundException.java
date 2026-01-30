package com.betrybe.alexandria.services.exception;

public class BookNotFoundException extends NotFoundException {
  public BookNotFoundException() {
    super("Livro não encontrado");
  }
}
