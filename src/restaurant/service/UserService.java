package restaurant.service;

import restaurant.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private final Map<String, User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    public User getUser(String userId) {
        return this.users.get(userId);
    }

    public String addUser() {
        User user = new User();
        users.put(user.getId(), user);
        return user.getId();
    }
}
