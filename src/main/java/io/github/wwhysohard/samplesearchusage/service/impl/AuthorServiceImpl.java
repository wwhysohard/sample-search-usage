package io.github.wwhysohard.samplesearchusage.service.impl;

import io.github.wwhysohard.samplesearchusage.model.Author;
import io.github.wwhysohard.samplesearchusage.repository.AuthorRepository;
import io.github.wwhysohard.samplesearchusage.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

    @Override
    public Page<Author> getAll(Specification<Author> specification, Pageable pageable) {
        return repository.findAll(specification, pageable);
    }

}
