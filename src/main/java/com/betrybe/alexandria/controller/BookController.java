package com.betrybe.alexandria.controller;

import com.betrybe.alexandria.controller.dto.BookCreationDto;
import com.betrybe.alexandria.controller.dto.BookDetailCreationDto;
import com.betrybe.alexandria.controller.dto.BookDetailDto;
import com.betrybe.alexandria.controller.dto.BookDto;
import com.betrybe.alexandria.entity.Book;
import com.betrybe.alexandria.services.BookService;
import com.betrybe.alexandria.services.exception.AuthorNotFoundException;
import com.betrybe.alexandria.services.exception.BookDetailNotFoundException;
import com.betrybe.alexandria.services.exception.BookNotFoundException;
import java.util.List;

import com.betrybe.alexandria.services.exception.PublisherNotFoundException;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


/**
 * The type Book controller.
 */
@RestController
@RequestMapping(value = "/books")
public class BookController {
  private final BookService bookService;

  /**
   * Instantiates a new Book controller.
   *
   * @param bookService the book service
   */
  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  /**
   * Gets book by id.
   *
   * @param id the id
   * @return the book by id
   * @throws BookNotFoundException the book not found exception
   */
  @GetMapping("/{id}")
  public BookDto getBookById(@PathVariable Long id) throws BookNotFoundException {
    return BookDto.fromEntity(
            this.bookService.findById(id)
    );
  }

  /**
   * Gets all books.
   *
   * @return the all books
   */
  @GetMapping
  public List<BookDto> getAllBooks(
          @RequestParam(required = false, defaultValue = "0") int pageNumber,
          @RequestParam(required = false, defaultValue = "10") int pageSize
  ) {
    List<Book> allBooks = this.bookService.findAll(pageNumber, pageSize);
    return allBooks.stream()
            .map(BookDto::fromEntity)
            .toList();
  }

  /**
   * Create book book dto.
   *
   * @param bookCreationDto the book creation dto
   * @return the book dto
   */
  @PostMapping
  public BookDto createBook(@RequestBody BookCreationDto bookCreationDto) {
    return BookDto.fromEntity(
           bookService.create(bookCreationDto.toEntity())
    );
  }

  /**
   * Update book book dto.
   *
   * @param id              the id
   * @param bookCreationDto the book creation dto
   * @return the book dto
   * @throws BookNotFoundException the book not found exception
   */
  @PutMapping("/{id}")
  public BookDto updateBook(@PathVariable Long id, @RequestBody BookCreationDto bookCreationDto)
          throws BookNotFoundException {
    return BookDto.fromEntity(
            bookService.update(id, bookCreationDto.toEntity())
    );
  }

  /**
   * Delete book by id book dto.
   *
   * @param id the id
   * @return the book dto
   * @throws BookNotFoundException the book not found exception
   */
  @DeleteMapping("/{id}")
  public BookDto deleteBookById(@PathVariable Long id) throws BookNotFoundException {
    return BookDto.fromEntity(
            bookService.delete(id)
    );
  }

  /**
   * Create book detail book detail dto.
   *
   * @param bookId                the book id
   * @param bookDetailCreationDto the book detail creation dto
   * @return the book detail dto
   * @throws BookNotFoundException the book not found exception
   */
  @PostMapping("/{bookId}/detail")
  @ResponseStatus(HttpStatus.CREATED)
  public BookDetailDto createBookDetail(@PathVariable Long bookId,
                                        @RequestBody BookDetailCreationDto bookDetailCreationDto)
      throws BookNotFoundException {
    return BookDetailDto.fromEntity(
            bookService.createBookDetail(bookId, bookDetailCreationDto.toEntity())
    );
  }

  /**
   * Gets book detail by id.
   *
   * @param bookId the book id
   * @return the book detail by id
   * @throws BookNotFoundException       the book not found exception
   * @throws BookDetailNotFoundException the book detail not found exception
   */
  @GetMapping("/{bookId}/detail")
  public BookDetailDto getBookDetailById(@PathVariable Long bookId)
          throws BookNotFoundException, BookDetailNotFoundException {
    return BookDetailDto.fromEntity(bookService.getBookDetail(bookId));
  }

  /**
   * Update book detail book detail dto.
   *
   * @param bookId                the book id
   * @param bookDetailCreationDto the book detail creation dto
   * @return the book detail dto
   * @throws BookNotFoundException       the book not found exception
   * @throws BookDetailNotFoundException the book detail not found exception
   */
  @PutMapping("/{bookId}/detail")
  public BookDetailDto updateBookDetail(@PathVariable Long bookId,
                                        @RequestBody BookDetailCreationDto bookDetailCreationDto)
      throws BookNotFoundException, BookDetailNotFoundException {
    return BookDetailDto.fromEntity(
           bookService.updateBookDetail(bookId, bookDetailCreationDto.toEntity())
    );
  }

  /**
   * Remove book detail book detail dto.
   *
   * @param bookId the book id
   * @return the book detail dto
   * @throws BookNotFoundException       the book not found exception
   * @throws BookDetailNotFoundException the book detail not found exception
   */
  @DeleteMapping("/{bookId}/detail")
  public BookDetailDto removeBookDetail(@PathVariable Long bookId)
          throws BookNotFoundException, BookDetailNotFoundException {
    return BookDetailDto.fromEntity(
            bookService.deleteBookDetail(bookId)
    );
  }

  @PutMapping("/{bookId}/publisher/{publisherId}")
  public BookDto setBookPublisher(@PathVariable Long bookId, @PathVariable Long publisherId)
         throws BookNotFoundException, PublisherNotFoundException {
    return BookDto.fromEntity(
            bookService.setBookPublisher(bookId, publisherId)
    );
  }

  @DeleteMapping("/{bookId}/publisher")
  public BookDto removeBookPublisher(@PathVariable Long bookId)
          throws BookNotFoundException {
    return BookDto.fromEntity(
            bookService.removeBookPublisher(bookId)
    );
  }

  @PutMapping("/{bookId}/authors/{authorId}")
  public BookDto addBookAuthor(@PathVariable Long bookId, @PathVariable Long authorId)
          throws BookNotFoundException, AuthorNotFoundException {
    return BookDto.fromEntity(
            bookService.addBookAuthor(bookId, authorId)
    );
  }

  @DeleteMapping("/{bookId}/authors/{authorId}")
  public BookDto removeBookAuthor(@PathVariable Long bookId, @PathVariable Long authorId)
          throws BookNotFoundException, AuthorNotFoundException {
    return BookDto.fromEntity(
            bookService.removeBookAuthor(bookId, authorId)
    );
  }
}
