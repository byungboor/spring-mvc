package x3.benjamin.playground.apiserver.model;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CreateUserListCommand {

	@Valid
	@NotEmpty(message = "createUserCommands is empty!!")
	private List<CreateUserCommand> createUserCommands;
	
	@JsonCreator
    public CreateUserListCommand(List<CreateUserCommand> createUserCommands) {
        this.createUserCommands = createUserCommands;
    }
	
	public List<CreateUserCommand> getCreateUserCommands() {
		return this.createUserCommands;
	}
	
	public void setCreateUserCommands(List<CreateUserCommand> createUserCommands) {
		this.createUserCommands = createUserCommands;
	}
}
