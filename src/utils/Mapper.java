package utils;

import data.models.Mail;
import data.models.User;
import dtos.requests.RegisterRequest;
import dtos.requests.SendMailRequest;

public class Mapper {
    public static User map(RegisterRequest registerRequest) {
        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setDateOfBirth(registerRequest.getDateOfBirth());
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        return user;
    }

    public static Mail map(SendMailRequest sendMailRequest) {
        Mail mail = new Mail();
        mail.setReceiver(sendMailRequest.getReceiver());
        mail.setSubject(sendMailRequest.getSubject());
        mail.setBody(sendMailRequest.getBody());
        return mail;
    }
}