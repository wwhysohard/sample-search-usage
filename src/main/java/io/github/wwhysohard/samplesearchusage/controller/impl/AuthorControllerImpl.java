package io.github.wwhysohard.samplesearchusage.controller.impl;

import io.github.wwhysohard.samplesearchusage.controller.AuthorController;
import io.github.wwhysohard.samplesearchusage.model.Author;
import io.github.wwhysohard.samplesearchusage.response.AuthorResponse;
import io.github.wwhysohard.samplesearchusage.service.AuthorService;
import io.github.wwhysohard.samplesearchusage.specification.AuthorSpecification;
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
public class AuthorControllerImpl implements AuthorController {

    private final AuthorService service;

    @Override
    public ResponseEntity<Page<AuthorResponse>> getAll(SearchRequest request, int page, int size) {
        Specification<Author> specification = new AuthorSpecification(request);
        Pageable pageable = PageRequest.of(page, size);

        Page<AuthorResponse> authors = service.getAll(specification, pageable)
                .map(author -> AuthorResponse.builder()
                            .withId(author.getId())
                            .withName(author.getName())
                            .withAddress(author.getAddress())
                        .build());

        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

}
