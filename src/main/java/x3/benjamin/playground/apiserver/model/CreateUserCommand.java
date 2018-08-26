package x3.benjamin.playground.apiserver.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateUserCommand {

    private Long id;
    private String name;
    private String address;

    private CreateUserCommand() {

    }
}
