package io.github.wwhysohard.samplesearchusage.controller;

import io.github.wwhysohard.samplesearchusage.response.BookResponse;
import io.github.wwhysohard.search.dto.SearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@RequestMapping("book")
public interface BookController {

    @PostMapping("all")
    ResponseEntity<Page<BookResponse>> getAll(@Valid @RequestBody SearchRequest request,
                                              @RequestParam(value = "page", defaultValue = "0") int page,
                                              @RequestParam(value = "size", defaultValue = "10") int size);

}
