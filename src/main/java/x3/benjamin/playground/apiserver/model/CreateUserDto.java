package x3.benjamin.playground.apiserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateUserDto {

    @JsonProperty("id")
    private Long userId;

    public CreateUserDto(Long userId) {
        this.userId = userId;
    }
}
