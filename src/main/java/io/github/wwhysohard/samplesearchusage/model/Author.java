package io.github.wwhysohard.samplesearchusage.model;

import io.github.wwhysohard.search.annotation.Filterable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Author {

    @Id
    @Filterable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Filterable
    private String name;

    @Filterable(joinable = true)
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    private String address;

}
