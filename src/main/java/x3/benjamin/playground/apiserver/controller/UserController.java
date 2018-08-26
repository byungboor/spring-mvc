package x3.benjamin.playground.apiserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import x3.benjamin.playground.apiserver.model.CreateUserCommand;
import x3.benjamin.playground.apiserver.model.CreateUserDto;
import x3.benjamin.playground.apiserver.model.User;
import x3.benjamin.playground.apiserver.service.UserService;

import java.util.List;

/**
 * Created by benjamin on 2017. 2. 14..
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        System.out.println("Controller Layer - users method is called");
        return userService.getUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<CreateUserDto> createUsers(@RequestHeader("x-msa-component") String component,
                                           @RequestBody List<CreateUserCommand> createUserCommands) {

        System.out.println("component : " + component);

        return userService.createUsers(createUserCommands);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{userId}")
    public User getUserById(@PathVariable(name = "userId") Long userId) {
        return userService.getUserById(userId);
    }
}
