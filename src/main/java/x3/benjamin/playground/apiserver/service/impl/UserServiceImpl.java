package x3.benjamin.playground.apiserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import x3.benjamin.playground.apiserver.model.CreateUserCommand;
import x3.benjamin.playground.apiserver.model.CreateUserDto;
import x3.benjamin.playground.apiserver.model.User;
import x3.benjamin.playground.apiserver.repository.UserRepository;
import x3.benjamin.playground.apiserver.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by benjamin on 2017. 2. 14..
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        System.out.println("Service Layer - users method is called");
        return userRepository.findAll();
    }

    @Override
    public List<CreateUserDto> createUsers(List<CreateUserCommand> createUserCommands) {
        System.out.println("Service Layer - createUsers method is called");
        List<User> users = createUserCommands.stream()
                .map(createUserCommand -> new User(createUserCommand.getId(), createUserCommand.getName(), createUserCommand.getAddress()))
                .collect(Collectors.toList());
        List<Long> ids = userRepository.saveAll(users);

        return ids.stream()
                .map(CreateUserDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findOne(userId);
    }
}
