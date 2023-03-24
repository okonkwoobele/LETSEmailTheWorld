package controller;

import dtos.requests.LoginRequest;
import dtos.requests.RegisterRequest;
import services.UserService;
import services.UserServiceImpl;

public class UserController {
    private final UserService userService = new UserServiceImpl();

    public Object registerUser(RegisterRequest request) {
        try {
            return userService.register(request);
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
    }

    public Object loginUser(LoginRequest request) {
        try {
            return userService.login(request);
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
    }
}