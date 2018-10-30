package x3.benjamin.playground.apiserver.model.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import x3.benjamin.playground.apiserver.model.CreateUserListCommand;
import x3.benjamin.playground.apiserver.model.UpdateUserCommand;

@Component
public class CreateUserListCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CreateUserListCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		CreateUserListCommand createUserListCommand = CreateUserListCommand.class.cast(target);

		if (StringUtils.isEmpty(createUserListCommand.getCreateUserCommands())) {
			errors.rejectValue("createUserCommands", "", "empty!!");
		}
	}
}
