package io.github.wwhysohard.samplesearchusage.model;

import io.github.wwhysohard.search.annotation.Filterable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Book {

    @Id
    @Filterable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Filterable
    private String title;

    @ManyToOne
    @Filterable(joinable = true, names = {"writer"})
    private Author author;

}
