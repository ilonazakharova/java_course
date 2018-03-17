package ru.stqa.pft.addressbook;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

  public final ApplicationManager app = new ApplicationManager();

  @BeforeMethod
  public void setUp() throws Exception {
    app.wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
