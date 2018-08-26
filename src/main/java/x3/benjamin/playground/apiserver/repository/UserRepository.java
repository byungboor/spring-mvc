package x3.benjamin.playground.apiserver.repository;

import org.springframework.stereotype.Repository;
import x3.benjamin.playground.apiserver.model.User;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by benjamin on 2017. 2. 14..
 */
//TODO 01- 적절한 Stereotype Annotation 을 선언한다.
public class UserRepository {

    @PostConstruct
    public void init() {
        System.out.println("-----------------------------------------");
        System.out.println("@Repository Spring Bean init");
        System.out.println("-----------------------------------------");
    }


    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        users.add(new User(1L, "Benjmain", "Bundang"));
        users.add(new User(2L, "Manti", "Suwon"));
        users.add(new User(3L, "Yoda", "Suwon"));
        users.add(new User(4L, "Dugi", "Seoul"));
        users.add(new User(5L, "Franky", "Bundang"));

        return users;
    }
}
