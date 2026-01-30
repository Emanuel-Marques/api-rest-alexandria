package com.betrybe.alexandria.controller;

import com.betrybe.alexandria.controller.dto.AuthorCreationDto;
import com.betrybe.alexandria.controller.dto.AuthorDto;
import com.betrybe.alexandria.entity.Author;
import com.betrybe.alexandria.services.AuthorService;
import com.betrybe.alexandria.services.exception.AuthorNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * The type Author controller.
 */
@RestController
@RequestMapping("/authors")
public class AuthorController {
  private final AuthorService  authorService;

  /**
   * Instantiates a new Author controller.
   *
   * @param authorService the author service
   */
  @Autowired
  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  /**
   * Gets author by id.
   *
   * @param id the id
   * @return the author by id
   * @throws AuthorNotFoundException the author not found exception
   */
  @GetMapping("/{id}")
  public AuthorDto getAuthorById(@PathVariable Long id) throws AuthorNotFoundException {
    return AuthorDto.fromEntity(
            this.authorService.findById(id)
    );
  }

  /**
   * Gets all authors.
   *
   * @return the all authors
   */
  @GetMapping
  public List<AuthorDto> getAllAuthors() {
    List<Author> allAuthors = this.authorService.findAll();
    return allAuthors.stream()
            .map(AuthorDto::fromEntity)
            .toList();
  }

  /**
   * Create author author dto.
   *
   * @param authorCreationDto the author creation dto
   * @return the author dto
   */
  @PostMapping
  public AuthorDto createAuthor(@RequestBody AuthorCreationDto authorCreationDto) {
    return AuthorDto.fromEntity(
            authorService.create(authorCreationDto.toEntity())
    );
  }

  /**
   * Update book author dto.
   *
   * @param id                the id
   * @param authorCreationDto the author creation dto
   * @return the author dto
   * @throws AuthorNotFoundException the author not found exception
   */
  @PutMapping("/{id}")
  public AuthorDto updateBook(
          @PathVariable Long id,
          @RequestBody AuthorCreationDto authorCreationDto
  ) throws AuthorNotFoundException {
    return AuthorDto.fromEntity(
            authorService.update(id, authorCreationDto.toEntity())
    );
  }

  /**
   * Delete author by id author dto.
   *
   * @param id the id
   * @return the author dto
   * @throws AuthorNotFoundException the author not found exception
   */
  @DeleteMapping("/{id}")
  public AuthorDto deleteAuthorById(@PathVariable Long id) throws AuthorNotFoundException {
    return AuthorDto.fromEntity(
            authorService.deleteById(id)
    );
  }

}
