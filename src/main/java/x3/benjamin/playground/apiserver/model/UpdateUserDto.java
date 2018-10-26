package x3.benjamin.playground.apiserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateUserDto {
    @JsonProperty("id")
    private Long userId;

    public UpdateUserDto(Long userId) {
        this.userId = userId;
    }
}
