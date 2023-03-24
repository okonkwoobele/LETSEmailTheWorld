package services;

import dtos.requests.LoginRequest;
import dtos.requests.RegisterRequest;
import dtos.requests.SendMailRequest;
import dtos.responses.LoginResponse;
import dtos.responses.RegisterResponse;

public interface UserService {
    RegisterResponse register(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);
    void sendMail(SendMailRequest sendMailRequest);
}