package data.repositories;

import data.models.Mail;
import java.util.ArrayList;
import java.util.List;

public class MailRepositoryImpl implements MailRepository {
    private List<Mail> mail;
    List<Mail> outbox = new ArrayList<>();
    List<Mail> drafts = new ArrayList<>();
    List<Mail> trash = new ArrayList<>();

    public MailRepositoryImpl() {
        this.mail = new ArrayList<>();
    }

    @Override
    public void addMail(Mail mail) {
        this.mail.add(mail);
    }

    @Override
    public void deleteMail(Mail mail) {
        this.mail.remove(mail);
    }

    @Override
    public Mail findMailById(int mailId) {
        for (Mail mail : this.mail) {
            if (mail.getEmailId() == mailId) {
                return mail;
            }
        }
        return null;
    }

    @Override
    public List<Mail> findAllMails() {
        return new ArrayList<>(this.mail);
    }

    @Override
    public List<Mail> getOutbox() {
        return outbox;
    }

    @Override
    public List<Mail> getDrafts() {
        return drafts;
    }

    @Override
    public List<Mail> getTrash() {
        return trash;
    }

    public Mail save(Mail mail) {
        return mail;
    }

    public long countAll() {
        return 0;
    }

    public void saveNewEmail(Mail mail) {
    }

    public void findById(int i) {
    }
}