package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class RegistrationTests extends TestBase{

  //@BeforeMethod - отключаем, т.к. будем использовать отдельно стоящий сервер, а не встроенный
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testRegistration() throws IOException, javax.mail.MessagingException {
    Long longtime = System.currentTimeMillis();
    String user = String.format("user%d", longtime);
    String password = "password";
    String email = String.format("%s@localhost.localhost", user);
    //создаем пользователя на почтовом сервере
    app.james().createUser(user, password);
    // выполняется 1-ая часть регистрации, должны получить письмо
    app.registration().start(user, email);
    //List<MailMessage> mailMessages = app.mail().waitForMail(2, 1000);
    //получаем письмо из внешнего почтового сервера
    List<MailMessage> mailMessages = app.james().waitForMail(user, password, 360000); // где должен быть метод waitForMail - в JamesHelper или в MailHelper
    String confirmationLink = findConfirmationLink(mailMessages, email);
    app.registration().finish(confirmationLink, password);
    assertTrue(app.newSession().login(user, password));
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  //@AfterMethod(alwaysRun = true) - отключаем, т.к. будем использовать отдельно стоящий сервер, а не встроенный
  public void stopMailServer() {
    app.mail().stop();
  }
}