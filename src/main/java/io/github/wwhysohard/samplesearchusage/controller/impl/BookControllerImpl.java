package io.github.wwhysohard.samplesearchusage.controller.impl;

import io.github.wwhysohard.samplesearchusage.controller.BookController;
import io.github.wwhysohard.samplesearchusage.model.Book;
import io.github.wwhysohard.samplesearchusage.response.BookResponse;
import io.github.wwhysohard.samplesearchusage.service.BookService;
import io.github.wwhysohard.samplesearchusage.specification.BookSpecification;
import io.github.wwhysohard.search.dto.SearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookControllerImpl implements BookController {

    private final BookService service;

    @Override
    public ResponseEntity<Page<BookResponse>> getAll(SearchRequest request, int page, int size) {
        Specification<Book> specification = new BookSpecification(request);
        Pageable pageable = PageRequest.of(page, size);

        Page<BookResponse> books = service.getAll(specification, pageable)
                .map(book -> BookResponse.builder()
                            .withId(book.getId())
                            .withTitle(book.getTitle())
                            .withAuthorName(book.getAuthor().getName())
                        .build());

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

}
