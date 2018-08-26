package x3.benjamin.playground.apiserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import x3.benjamin.playground.apiserver.model.User;
import x3.benjamin.playground.apiserver.service.UserService;

import java.util.List;

/**
 * Created by benjamin on 2017. 2. 14..
 */
// TODO - 03. 적절한 Sterotype annotation 을 사용하여 Bean 선언을 합니다.
// 단. annotation 에 따라서 Api method signature 가 다를수 있으니 아래 getUsers 메소드의 형태를 보고 적절히 잘 판단하세요.
public class UserController {

    @Autowired
    private UserService userService;

    // TODO - 04. 클라이언트에서 요청하는 URL에 맞게 RequestMapping 을 선언하세요.
    //  path 는 '/users' 이고 http method 는 GET 입니다.
    public List<User> getUsers() {
        System.out.println("Controller Layer - users method is called");
        return userService.getUsers();
    }
}
