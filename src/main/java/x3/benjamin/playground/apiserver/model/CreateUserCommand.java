package x3.benjamin.playground.apiserver.model;

import javax.validation.constraints.NotNull;

public class CreateUserCommand {

    private Long id;
    @NotNull(message = "name should not be null")
    private String name;
    private String address;

    private CreateUserCommand() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
