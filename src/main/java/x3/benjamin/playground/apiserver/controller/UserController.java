package x3.benjamin.playground.apiserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import x3.benjamin.playground.apiserver.exception.ApiValidationException;
import x3.benjamin.playground.apiserver.model.CreateUserCommand;
import x3.benjamin.playground.apiserver.model.CreateUserDto;
import x3.benjamin.playground.apiserver.model.CreateUserListCommand;
import x3.benjamin.playground.apiserver.model.UpdateUserCommand;
import x3.benjamin.playground.apiserver.model.UpdateUserDto;
import x3.benjamin.playground.apiserver.model.User;
import x3.benjamin.playground.apiserver.model.validator.UpdateUserCommandValidator;
import x3.benjamin.playground.apiserver.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by benjamin on 2017. 2. 14..
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UpdateUserCommandValidator updateUserCommandValidator;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        System.out.println("Controller Layer - users method is called");
        return userService.getUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<CreateUserDto> createUsers(@RequestHeader("x-msa-component") String component,
                                           @RequestBody @Valid CreateUserListCommand createUserListCommand) {

        System.out.println("component : " + component);
        
        return userService.createUsers(createUserListCommand.getCreateUserCommands());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{userId}")
    public User getUserById(@PathVariable(name = "userId") Long userId) {
        return userService.getUserById(userId);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{userId}")
    public UpdateUserDto updateUserById(@PathVariable(name = "userId") Long userId,
                                        @RequestBody @Valid UpdateUserCommand updateUserCommand,
                                        BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            StringJoiner errorJoiner = new StringJoiner(" | ");
            bindingResult.getAllErrors().stream()
                         .map(error ->
                                      new StringBuilder().append("ObjectName=").append(error.getObjectName())
                                                         .append(",Message=").append(error.getDefaultMessage())
                                                         .append(",code=").append(error.getCode())

                             )
                         .forEach(errorJoiner::add);
            throw new ApiValidationException(errorJoiner.toString());
        }


        System.out.println("updateUserCommand : " + updateUserCommand.toString());

        //Skip business logic

        return new UpdateUserDto(userId);
    }

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        binder.addValidators(updateUserCommandValidator);
    }


}
