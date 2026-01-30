package com.betrybe.alexandria.services.exception;

/**
 * The type Publisher not found exception.
 */
public class PublisherNotFoundException extends NotFoundException {
  /**
   * Instantiates a new Publisher not found exception.
   *
   */
  public PublisherNotFoundException() {
    super("Editora não encontrada!");
  }
}
