package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.ContactData;

public class ContactHelper {
  private WebDriver wd;

  public ContactHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  private void click(By locator) {
    wd.findElement(locator).click();
  }

  public void fillContactForm(ContactData contactData) {
    fname(By.name("firstname"), contactData.getFirstName());
    fname(By.name("middlename"), contactData.getMiddleName());
    fname(By.name("lastname"), contactData.getLastName());
    fname(By.name("nickname"), contactData.getNickName());
    fname(By.name("title"), contactData.getTitle());
    fname(By.name("company"), contactData.getCompany());
    fname(By.name("address"), contactData.getAddress());
    fname(By.name("home"), contactData.getHomePhone());
    fname(By.name("mobile"), contactData.getMobilePhone());
    fname(By.name("work"), contactData.getWorkPhone());
    fname(By.name("fax"), contactData.getFaxPhone());
    fname(By.name("email"), contactData.getEmail1());
    fname(By.name("email2"), contactData.getEmail2());
    fname(By.name("email3"), contactData.getEmail3());

  }

  private void fname(By fnlocator, String text) {
    click(fnlocator);
    wd.findElement(fnlocator).clear();
    wd.findElement(fnlocator).sendKeys(text);
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }
}
