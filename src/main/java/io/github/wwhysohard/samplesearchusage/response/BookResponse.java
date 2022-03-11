package io.github.wwhysohard.samplesearchusage.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "with")
public class BookResponse {

    private Long id;
    private String title;
    private String authorName;

}
