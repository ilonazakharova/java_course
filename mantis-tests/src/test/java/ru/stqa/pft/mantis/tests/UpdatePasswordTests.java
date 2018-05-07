package ru.stqa.pft.mantis.tests;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class UpdatePasswordTests extends TestBase {

  //@BeforeMethod //- отключаем, т.к. будем использовать отдельно стоящий сервер, а не встроенный
  public void startMailServer() {
    app.mail().start();
  }


  @Test
  public void testUpdatePassword() throws IOException, javax.mail.MessagingException, MessagingException {
    Long longtime = System.currentTimeMillis();
    String user = "user11"; //логин пользователя для которого меняем пароль
    String password = "password"; //старый пароль
    String newpassword = "password1"; //новый пароль
    String email = "10user@localhost"; //емейл пользователя, которому меняют пароль
    app.navigate().login(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword")); //авторизоваться в мантис, как администратор
    app.updateHelper().changePassword(user);

    //List<MailMessage> mailMessages = app.james().waitForMail(user, password, 60000);
   List<MailMessage> mailMessages = app.mail().waitForMail(2, 1000);

    String confirmationLink = findConfirmationLink(mailMessages, email);
    app.updateHelper().confirmPassword(confirmationLink, newpassword); //подтверждаем смену пароля
    assertTrue(app.newSession().login(user, newpassword)); //проаверяем, что пользователь может авторизоваться с новым паролем
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }


  //@AfterMethod(alwaysRun = true) //- отключаем, т.к. будем использовать отдельно стоящий сервер, а не встроенный
  public void stopMailServer() {
    app.mail().stop();
  }
}
