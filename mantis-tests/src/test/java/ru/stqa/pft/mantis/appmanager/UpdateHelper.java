package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class UpdateHelper extends HelperBase{

  public UpdateHelper(ApplicationManager app) {
    super(app);
  }

  public void changePassword(String username) {

    click(By.cssSelector("a[href='/mantisbt-2.14.0/manage_overview_page.php']")); //нажимаем на ссылку "Управление"
    click(By.cssSelector("a[href='/mantisbt-2.14.0/manage_user_page.php']"));
    type(By.name("username"), username);
    click(By.xpath("(//input)[10]")); //нажимаем кнопку "Изменить учетную запись"
  }

  public void confirmPassword(String link, String password) {
    wd.get(link);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("button[type='submit']"));
  }

}

