package io.github.wwhysohard.samplesearchusage.specification;

import io.github.wwhysohard.samplesearchusage.model.Author;
import io.github.wwhysohard.samplesearchusage.model.Book;
import io.github.wwhysohard.search.dto.SearchRequest;
import io.github.wwhysohard.search.specification.GenericSpecification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

public class AuthorSpecification extends GenericSpecification<Author> {

    public AuthorSpecification(SearchRequest request) {
        super(request, Author.class, true);
    }

    @Override
    protected void initializeJoins(Root<Author> root) {
        Join<Author, Book> books = root.join("books", JoinType.LEFT);
        joins.put("books", books);
    }

}
