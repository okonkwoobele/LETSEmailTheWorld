import data.models.Mail;
import data.repositories.MailRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailRepositoryImplTest {

    MailRepositoryImpl mailRepository;
    @BeforeEach
    void setUp() {
        mailRepository = new MailRepositoryImpl();
    }

    @Test
    void save() {
        Mail mail = new Mail();
        mailRepository.save(mail);
        mailRepository.save(mail);
        assertEquals(2L, mailRepository.countAll());
    }

    @Test
    void saveNewEmail() {
        Mail mail =new Mail();
        mailRepository.saveNewEmail(mail);
        mailRepository.saveNewEmail(mail);
        assertEquals(2L,mailRepository.countAll());
    }

    @Test
    void findById() {
        Mail mail = new Mail();
        mailRepository.findById(1);
     // assertEquals(1,mailRepository.countAll());
    }

    @Test
    void countByAccountId() {
    }

    @Test
    void deleteById() {
    }
    @Test
    void findAll() {
    }

    @Test
    void countAll() {
    }
}