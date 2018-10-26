package x3.benjamin.playground.apiserver.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class UpdateUserCommand {

    //TODO 2
    @NotNull(message = "name should not be null")
    private String name;
    @NotEmpty(message = "address should not be empty")
    private String address;

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
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UpdateUserCommand{");
        sb.append("name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
