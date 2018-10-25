package x3.benjamin.playground.apiserver.service;


import x3.benjamin.playground.apiserver.model.CreateUserCommand;
import x3.benjamin.playground.apiserver.model.CreateUserDto;
import x3.benjamin.playground.apiserver.model.User;

import java.util.List;

/**
 * Created by benjamin on 2017. 2. 14..
 */
public interface UserService {

    List<User> getUsers();

    List<CreateUserDto> createUsers(List<CreateUserCommand> createUserCommands);

    User getUserById(Long userId);

}
