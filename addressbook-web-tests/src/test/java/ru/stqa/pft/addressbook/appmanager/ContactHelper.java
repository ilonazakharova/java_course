package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.openqa.selenium.By.name;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) { super(wd); }

  public void initContactCreation() { click(By.linkText("add new"));}

  public void selectContact() { click(name("selected[]")); }

  public void deleteSelectedContacts() { click(By.xpath("//div[@id='content']/form[2]/div[2]/input")); }

  public void fillContactForm(ContactData contactData, boolean creation)
  {
    type(name("firstname"), contactData.getFirstName());
    type(name("middlename"), contactData.getMiddleName());
    type(name("lastname"), contactData.getLastName());
    type(name("nickname"), contactData.getNickName());
    type(name("title"), contactData.getTitle());
    type(name("company"), contactData.getCompany());
    type(name("address"), contactData.getAddress());
    type(name("home"), contactData.getHomePhone());
    type(name("mobile"), contactData.getMobilePhone());
    type(name("work"), contactData.getWorkPhone());
    type(name("fax"), contactData.getFaxPhone());
    type(name("email"), contactData.getEmail1());
    type(name("email2"), contactData.getEmail2());
    type(name("email3"), contactData.getEmail3());

    if (creation) {
      new Select(wd.findElement(name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitContactCreation() { click(name("submit")); }

  public void closeWindow (){ wd.switchTo().alert().accept();}

  public void initContactModification() { click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")); }

  public void submitContactModification() { click(name("update")); }

}
