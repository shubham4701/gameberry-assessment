package restaurant.controller;

import restaurant.model.User;
import restaurant.service.UserService;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public String addUser() {
        return userService.addUser();
    }

    public User getUser(String userId) {
        return userService.getUser(userId);
    }
}
