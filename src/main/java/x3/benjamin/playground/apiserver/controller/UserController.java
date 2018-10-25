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

	// TODO - 1 POST method 로 RequestMapping 하세요.
	// TODO - 1 POST methodでRequestMappingて下さい。
	public List<CreateUserDto> createUsers(
			// TODO - 2 HTTP Header 값을 받으세요. 
			// TODO - 2 HTTP Header値を取得し
			String component, 

			// TODO - 3 POST 의 Body 를 받으세요
			// TODO - 3 POSTのBodyを取得
			List<CreateUserCommand> createUserCommands) {

		System.out.println("component : " + component);

		return userService.createUsers(createUserCommands);
	}

	// TODO - 4 GET method 로 RequestMapping 하세요. API spec 의 path 를 잘 보세요
	// TODO - 4 GET methodでRequestMappingて下さい。API specのpathをよく見てください
	public User getUserById(Long userId // TODO - 어떻게 서로 맵핑할까요?, どのようにお互いにマッピングでしょうか？
	) {
		return userService.getUserById(userId);
	}
}
