package controller;

import data.models.Mail;
import dtos.requests.SendMailRequest;
import services.MailService;
import services.MailServiceImpl;
import java.util.List;

public class MailController {
    private final MailService mailService = new MailServiceImpl();

    public String sendMail(SendMailRequest request) {
        try {
            return mailService.sendMail(request);
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
    }

    public List<Mail> getAllMails() { return mailService.viewAllMails(); }
    public List<Mail> getOutbox() { return mailService.viewOutbox(); }
    public List<Mail> getDrafts() {return mailService.viewDrafts(); }
    public List<Mail> getTrash() { return mailService.viewTrash(); }
}