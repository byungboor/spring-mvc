package x3.benjamin.playground.apiserver.model.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import x3.benjamin.playground.apiserver.model.UpdateUserCommand;

@Component
public class UpdateUserCommandValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UpdateUserCommand.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UpdateUserCommand updateUserCommand = UpdateUserCommand.class.cast(target);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Username is empty");
        if (updateUserCommand.getName().length() < 2) {
            errors.rejectValue("name", "", "Username length is less than 2");
        }
    }
}
