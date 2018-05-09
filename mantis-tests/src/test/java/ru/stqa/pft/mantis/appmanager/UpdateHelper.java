package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateHelper extends HelperBase{
  WebDriverWait wait = new WebDriverWait(wd, 200);

  public UpdateHelper(ApplicationManager app) {
    super(app);
  }

  public void changePassword(String username) {
    click(By.xpath("//input[contains(@class, 'btn-success')]"));
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class, 'nav-list')]"))); //ожидание на загрузку элемента
    click(By.partialLinkText("Manage"));  //нажимаем на ссылку "Управление"
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class, 'nav-tabs')]")));
    click(By.xpath("//ul[contains(@class, 'nav-tabs')]/li[2]/a")); // нажимаем на ссылку "Изменить учетную запись"
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[contains(@class, 'table-striped')]")));
    type(By.name("username"), username);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class, 'clearfix')])[1]")));
    click(By.xpath("(//input[contains(@class, 'btn-round')])[2]"));
    click(By.cssSelector("input[value='Reset Password']")); //нажать кнопку для сброса пароля
    //type(By.name("username"), username);
    click(By.xpath("//span[@class='user-info']"));
    click(By.cssSelector("a[href='/mantisbt-2.14.0/logout_page.php']"));
  }

  public void confirmPassword(String link, String password) {
    wd.get(link);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("button[type='submit']"));

  }


  //public void enterNewPassword(String confirmationLink, String password) {
          // wd.get(confirmationLink);
           // type(By.id("password"), password);
           // type(By.id("password-confirm"), password);
           // click(By.cssSelector("input[value='Изменить учетную запись']"));
       // }


}


