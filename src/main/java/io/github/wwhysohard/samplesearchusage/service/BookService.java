package io.github.wwhysohard.samplesearchusage.service;

import io.github.wwhysohard.samplesearchusage.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
public interface BookService {

    Page<Book> getAll(Specification<Book> specification, @NotNull Pageable pageable);

}
