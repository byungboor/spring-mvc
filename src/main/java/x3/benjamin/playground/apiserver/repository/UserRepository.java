package x3.benjamin.playground.apiserver.repository;

import x3.benjamin.playground.apiserver.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Created by benjamin on 2017. 2. 14..
 */
@Repository
public class UserRepository {


    private Map<Long, User> userMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        userMap.put(1L, new User(1L, "Benjmain", "Bundang"));
        userMap.put(2L, new User(2L, "Manti", "Suwon"));
        userMap.put(3L, new User(3L, "Yoda", "Suwon"));
        userMap.put(4L, new User(4L, "Dugi", "Seoul"));
        userMap.put(5L, new User(5L, "Franky", "Bundang"));
    }

    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }

    public List<Long> saveAll(List<User> users) {
        return users.stream()
                .map(user -> {
                    userMap.put(user.getUserId(), user);
                    return user.getUserId();
                })
                .collect(Collectors.toList());
    }

    public User findOne(Long userId) {
        return userMap.getOrDefault(userId, null);
    }
}
