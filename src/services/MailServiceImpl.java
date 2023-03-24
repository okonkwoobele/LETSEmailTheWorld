package services;

import data.models.Mail;
import data.repositories.MailRepository;
import data.repositories.MailRepositoryImpl;
import dtos.requests.SendMailRequest;
import utils.GenerateId;
import utils.MailSender;
import utils.Mapper;
import java.util.List;

public class MailServiceImpl implements MailService {
    MailRepository mailRepository = new MailRepositoryImpl();
    List<Mail> mails = mailRepository.findAllMails();
    List<Mail> outbox = mailRepository.getOutbox();
    List<Mail> drafts = mailRepository.getDrafts();
    List<Mail> trash = mailRepository.getTrash();

    @Override
    public String sendMail(SendMailRequest sendMailRequest) {
        Mail mail = Mapper.map(sendMailRequest);
        mail.setEmailId(GenerateId.generateId(mails.size()));
        mails.add(mail);
        if (MailSender.sendMail(sendMailRequest)) {
            outbox.add(mail);
        } else {
            drafts.add(mail);
        }
        return null;
    }

    @Override
    public boolean moveMailToTrash(Mail mailId) {
        return trash.add(mailId);
    }

    @Override
    public List<Mail> viewAllMails() {
        return mails;
    }

    @Override
    public List<Mail> viewOutbox() {
        return outbox;
    }

    @Override
    public List<Mail> viewDrafts() {
        return drafts;
    }

    @Override
    public List<Mail> viewTrash() {
        return trash;
    }
}