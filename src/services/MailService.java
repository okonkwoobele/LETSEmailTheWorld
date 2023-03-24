package services;

import data.models.Mail;
import dtos.requests.SendMailRequest;
import java.util.List;

public interface MailService {
    String sendMail(SendMailRequest sendMailRequest);
    boolean moveMailToTrash(Mail mailId);
    List<Mail> viewAllMails();
    List<Mail> viewOutbox();
    List<Mail> viewDrafts();
    List<Mail> viewTrash();
}