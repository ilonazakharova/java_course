package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.name;

public class ContactHelper extends HelperBase{

  public int index;

  public ContactHelper(WebDriver wd) { super(wd); }

  public void initContactCreation() { click(By.linkText("add new"));}

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click(); }


  public void initContactModification() {
    wd.findElements(By.xpath("//tr[@name='entry']")).get(index);
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")); }


  public void deleteSelectedContacts() { click(By.xpath("//div[@id='content']/form[2]/div[2]/input")); }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickName());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("fax"), contactData.getFaxPhone());
    type(By.name("email"), contactData.getEmail1());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());

    if (creation) {
      new Select(wd.findElement(name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));

    }

  }

  public void submitContactCreation() { click(name("submit")); }

  public void closeWindow (){ wd.switchTo().alert().accept();}

  public void submitContactModification() { click(name("update")); }

  public void createContact(ContactData contact) {
    initContactCreation();
    gotoContactPage();
    fillContactForm(contact, true);
    submitContactCreation();
    returnToHomePage();
  }

  public boolean isThereAContact() { return isElementPresent(By.name("selected[]")); }

  public int getContactCount() { return wd.findElements(By.name("selected[]")).size(); }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name = \"entry\"]"));
    for (WebElement element : elements) {
      String id = element.findElement(By.tagName("input")).getAttribute("value");
      String firstname = element.findElement(By.xpath("(//td[@class='center']/following-sibling::td)[1]")).getText();
      String lastname = element.findElement(By.xpath("(//td[@class='center']/following-sibling::td)[2]")).getText();
      ContactData contact = new ContactData(
              id,
              firstname,
              null,
              lastname,
              null,
              null,
              null,
              null,
              null,
              null,
              null,
              null,
              null,
              null,
              null,
              null);
      contacts.add(contact);
    }
    return contacts;
  }



}
