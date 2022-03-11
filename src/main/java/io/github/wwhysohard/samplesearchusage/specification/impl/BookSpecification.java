package io.github.wwhysohard.samplesearchusage.specification.impl;

import io.github.wwhysohard.samplesearchusage.model.Author;
import io.github.wwhysohard.samplesearchusage.model.Book;
import io.github.wwhysohard.samplesearchusage.specification.GenericSpecification;
import io.github.wwhysohard.search.dto.SearchRequest;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

public class BookSpecification extends GenericSpecification<Book> {

    public BookSpecification(SearchRequest request) {
        super(request, Book.class);
    }

    @Override
    protected void initializeJoins(Root<Book> root) {
        Join<Book, Author> author = root.join("author", JoinType.LEFT);
        joins.put("author", author);
        joins.put("writer", author);
    }

}
