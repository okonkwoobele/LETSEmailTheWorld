package services;

import data.models.User;
import data.repositories.UserRepository;
import data.repositories.UserRepositoryImpl;
import dtos.requests.LoginRequest;
import dtos.requests.RegisterRequest;
import dtos.requests.SendMailRequest;
import dtos.responses.LoginResponse;
import dtos.responses.RegisterResponse;
import utils.GenerateId;
import utils.Mapper;

import java.util.List;
import javax.swing.*;

public class UserServiceImpl implements UserService {
    MailService mailService = new MailServiceImpl();
    UserRepository userRepository = new UserRepositoryImpl();
    private final List<User> users = userRepository.findAllUsers();

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        try {
            for (User user : users) {
                if (user.getUsername().equals(registerRequest.getUsername())) {
                    JOptionPane.showMessageDialog(null, "Username already exists, try another username.");
                    throw new IllegalArgumentException("Username already exists.");
                }
            }
            User user = Mapper.map(registerRequest);
            user.setUserId(GenerateId.generateId(users.size()));
            users.add(user);
            String message = "User successfully created";
            JOptionPane.showMessageDialog(null, message);
            return new RegisterResponse(message, user.getUsername());
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            throw ex;
        }
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            for (User user : users) {
                if (user.getUsername().equals(loginRequest.getUsername()) && user.getPassword().equals(loginRequest.getPassword())) {
                    JOptionPane.showMessageDialog(null, "Login successful.");
                }
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Incorrect username or password");
            throw ex;
        }
        return new LoginResponse("Login successful");
    }

    @Override
    public void sendMail(SendMailRequest sendMailRequest) {
        mailService.sendMail(sendMailRequest);
    }
}