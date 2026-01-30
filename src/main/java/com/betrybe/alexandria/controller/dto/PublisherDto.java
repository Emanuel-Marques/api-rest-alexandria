package com.betrybe.alexandria.controller.dto;

import com.betrybe.alexandria.entity.Publisher;

/**
 * The type Publisher dto.
 */
public record PublisherDto(String name, String address) {

  /**
   * From entity publisher dto.
   *
   * @param publisher the publisher
   * @return the publisher dto
   */
  public static PublisherDto fromEntity(Publisher publisher) {
    return new PublisherDto(
            publisher.getName(),
            publisher.getName()
    );
  }
}
