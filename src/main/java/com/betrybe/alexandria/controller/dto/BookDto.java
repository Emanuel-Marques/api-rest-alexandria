package com.betrybe.alexandria.controller.dto;

import com.betrybe.alexandria.entity.Book;

/**
 * The type Book dto.
 */
public record BookDto(Long id, String title, String genre, PublisherDto publisher) {
  /**
   * From entity book dto.
   *
   * @param book the book
   * @return the book dto
   */
  public static BookDto fromEntity(Book book) {
    PublisherDto publisherDto = book.getPublisher() !=  null ?
            PublisherDto.fromEntity(book.getPublisher()) : null;
    return new BookDto(
            book.getId(),
            book.getTitle(),
            book.getGenre(),
            publisherDto
    );
  }

}
