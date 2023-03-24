package data.repositories;

import data.models.Mail;
import java.util.List;

public interface MailRepository {
        void addMail(Mail mail);
        void deleteMail(Mail mail);
        Mail findMailById(int mailId);
        List<Mail> findAllMails();
        List<Mail> getOutbox();
        List<Mail> getDrafts();
        List<Mail> getTrash();
}