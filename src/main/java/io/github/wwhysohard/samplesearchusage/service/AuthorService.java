package io.github.wwhysohard.samplesearchusage.service;

import io.github.wwhysohard.samplesearchusage.model.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
public interface AuthorService {

    Page<Author> getAll(Specification<Author> specification, @NotNull Pageable pageable);

}
