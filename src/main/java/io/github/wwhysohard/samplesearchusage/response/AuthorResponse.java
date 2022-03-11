package io.github.wwhysohard.samplesearchusage.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "with")
public class AuthorResponse {

    private Long id;
    private String name;
    private String address;

}
