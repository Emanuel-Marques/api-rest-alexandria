package com.betrybe.alexandria.controller;

import com.betrybe.alexandria.controller.dto.PublisherCreationDto;
import com.betrybe.alexandria.controller.dto.PublisherDto;
import com.betrybe.alexandria.entity.Publisher;
import com.betrybe.alexandria.services.PublisherService;
import com.betrybe.alexandria.services.exception.PublisherNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The type Publisher controller.
 */
@RestController
@RequestMapping("/publishers")
public class PublisherController {
  private final PublisherService publisherService;

  /**
   * Instantiates a new Publisher controller.
   *
   * @param publisherService the publisher service
   */
  @Autowired
  public PublisherController(PublisherService publisherService) {
    this.publisherService = publisherService;
  }

  /**
   * Gets publisher by id.
   *
   * @param id the id
   * @return the publisher by id
   * @throws PublisherNotFoundException the publisher not found exception
   */
  @GetMapping("/{id}")
  public PublisherDto getPublisherById(@PathVariable Long id) throws PublisherNotFoundException {
    return PublisherDto.fromEntity(
            this.publisherService.findById(id)
    );
  }


  /**
   * Gets all publishers.
   *
   * @return the all publishers
   */
  @GetMapping
  public List<PublisherDto> getAllPublishers() {
    List<Publisher> allPublishers = this.publisherService.findAll();
    return allPublishers.stream()
            .map(PublisherDto::fromEntity)
            .toList();
  }


  /**
   * Create publisher publisher dto.
   *
   * @param publisherCreationDto the publisher creation dto
   * @return the publisher dto
   */
  @PostMapping
  public PublisherDto createPublisher(@RequestBody PublisherCreationDto publisherCreationDto) {
    return PublisherDto.fromEntity(
            publisherService.create(publisherCreationDto.toEntity())
    );
  }


  /**
   * Update publisher dto.
   *
   * @param id                   the id
   * @param publisherCreationDto the publisher creation dto
   * @return the publisher dto
   * @throws PublisherNotFoundException the publisher not found exception
   */
  @PutMapping("/{id}")
  public PublisherDto updatePublisher(
          @PathVariable Long id,
          @RequestBody PublisherCreationDto publisherCreationDto
  ) throws PublisherNotFoundException {
    return PublisherDto.fromEntity(
            publisherService.update(id, publisherCreationDto.toEntity())
    );
  }


  /**
   * Delete publisher by id publisher dto.
   *
   * @param id the id
   * @return the publisher dto
   * @throws PublisherNotFoundException the publisher not found exception
   */
  @DeleteMapping("/{id}")
  public PublisherDto deletePublisherById(@PathVariable Long id) throws PublisherNotFoundException {
    return PublisherDto.fromEntity(
            publisherService.deleteById(id)
    );
  }
}
