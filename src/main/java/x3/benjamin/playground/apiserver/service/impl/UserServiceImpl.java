package x3.benjamin.playground.apiserver.service.impl;

import x3.benjamin.playground.apiserver.model.User;
import x3.benjamin.playground.apiserver.repository.UserRepository;
import x3.benjamin.playground.apiserver.service.UserService;

import java.util.List;

/**
 * Created by benjamin on 2017. 2. 14..
 */
// TODO - 01. 적절한 Sterotype annotation 을 사용하여 Bean 선언을 합니다.
// TODO - 01. 適切な Sterotype annotationを使用してBean宣言をします。
// e.g. @Controller, @Service, @Repository, @Component
public class UserServiceImpl implements UserService {

    // TODO - 02. 아래의 UserRepository 에 적절한 Bean 을 주입합니다. 이또한 Annotation 으로 처리가능합니다.
	// TODO - 02. 下のUserRepositoryに適切なBeanを注入します。これもAnnotationで処理が可能です。
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        System.out.println("Service Layer - users method is called");
        return userRepository.findAll();
    }
}
