package io.github.wwhysohard.samplesearchusage.controller;

import io.github.wwhysohard.samplesearchusage.response.AuthorResponse;
import io.github.wwhysohard.search.dto.SearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@RequestMapping("author")
public interface AuthorController {

    @PostMapping("all")
    ResponseEntity<Page<AuthorResponse>> getAll(@Valid @RequestBody SearchRequest request,
                                                @RequestParam(value = "page", defaultValue = "0") int page,
                                                @RequestParam(value = "size", defaultValue = "10") int size);

}
