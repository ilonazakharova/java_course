package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(ApplicationManager app) {
    super(app);
  }

  public void login(String username, String password) {
    wd.get(app.getProperty("web.baseUrl"));
    type(By.name("username"), username);
    click(By.xpath("(//input)[3]"));
    type(By.name("password"), password);
    click(By.xpath("(//input)[3]"));
  }
}
