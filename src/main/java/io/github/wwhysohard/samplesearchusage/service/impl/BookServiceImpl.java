package io.github.wwhysohard.samplesearchusage.service.impl;

import io.github.wwhysohard.samplesearchusage.model.Book;
import io.github.wwhysohard.samplesearchusage.repository.BookRepository;
import io.github.wwhysohard.samplesearchusage.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Override
    public Page<Book> getAll(Specification<Book> specification, Pageable pageable) {
        return repository.findAll(specification, pageable);
    }

}
