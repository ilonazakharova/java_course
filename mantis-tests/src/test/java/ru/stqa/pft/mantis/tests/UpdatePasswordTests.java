package ru.stqa.pft.mantis.tests;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserInformation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class UpdatePasswordTests extends TestBase {

  @BeforeMethod //- отключаем, т.к. будем использовать отдельно стоящий сервер, а не встроенный
  public void startMailServer() {
    app.mail().start();
  }
  private SessionFactory sessionFactory;


  @BeforeClass
  protected void initSessionFactory() throws Exception {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    try {
      sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    } catch (Exception e) {
      e.printStackTrace(); //вывод сообщения об ошибке на консоль
      // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
      // so destroy it manually.
      StandardServiceRegistryBuilder.destroy(registry);
    }
  }


  @Test
  public void testUpdatePassword() throws IOException, javax.mail.MessagingException, MessagingException, SQLException {
    Session session = sessionFactory.openSession();
    //session.beginTransaction();
    List<UserInformation> result = session.createQuery("from UserInformation where username like 'user%'").list();
    UserInformation user = result.get(0);
    Long longtime = System.currentTimeMillis();
    //String user = "user1525882854734"; //логин пользователя для которого меняем пароль
    String password = "password"; //старый пароль
    String newpassword = "password1"; //новый пароль
    String email = "user1525882854734@localhost"; //емейл пользователя, которому меняют пароль
    app.navigate().login(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword")); //авторизоваться в мантис, как администратор
    app.updateHelper().changePassword(user.getUserName());
    //List<MailMessage> mailMessages = app.james().waitForMail(user, password, 60000); //отключаем внешний почтовый сервер
    List<MailMessage> mailMessages = app.mail().waitForMail(7, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, email);
    app.updateHelper().confirmPassword(confirmationLink, newpassword); //подтверждаем смену пароля
    assertTrue(app.newSession().login(user.getUserName(), newpassword)); //проаверяем, что пользователь может авторизоваться с новым паролем
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }


 @AfterMethod(alwaysRun = true) //- отключаем, т.к. будем использовать отдельно стоящий сервер, а не встроенный
 private void stopMailServer() {
    app.mail().stop();
  }
}
