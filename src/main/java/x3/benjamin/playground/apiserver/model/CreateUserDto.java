package x3.benjamin.playground.apiserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
<<<<<<< HEAD

=======
import lombok.Getter;

@Getter
>>>>>>> todo 실습 마킹
public class CreateUserDto {

    @JsonProperty("id")
    private Long userId;

    public CreateUserDto(Long userId) {
        this.userId = userId;
    }
<<<<<<< HEAD
    
    public Long getUserId() {
    	return this.userId;
    }
=======
>>>>>>> todo 실습 마킹
}
