package ru.stqa.pft.addressbook.appmanager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.name;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) { super(wd); }

  public void initContactCreation() { click(By.linkText("add new")); }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click(); }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click(); }

  public void initContactModification(int index) {
    wd.findElement(By.xpath("//a[@href=\"edit.php?id=" + index + "\"]/img")).click();

  }

  public void modify(ContactData contact) {
    initContactModificationId(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
    homePage();
  }

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
    attach(By.name("photo"), contactData.getPhoto());

    if (creation) {
      new Select(wd.findElement(name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitContactCreation() { click(name("submit")); }

  public void closeWindow() { wd.switchTo().alert().accept(); }

  public void submitContactModification() { click(name("update")); }

  public void create(ContactData contact) {
    initContactCreation();
    contactPage();
    fillContactForm(contact, true);
    submitContactCreation();
    contactCache = null;
    homePage();
  }

  public void delete(int index) {
    selectContact (index);
    deleteSelectedContacts();
    closeWindow();
    contactCache = null;
    homePage();
  }

  public void delete(ContactData contact) {
    selectContactById (contact.getId());
    deleteSelectedContacts();
    closeWindow();
    contactCache = null;
    homePage();
  }

  public boolean isThereAContact() { return isElementPresent(By.name("selected[]")); }

  public int count() { return wd.findElements(By.name("selected[]")).size(); }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String address = cells.get(3).getText();
      String allEmails = cells.get(4).getText();
      String allPhones = cells.get(5).getText();
      contacts.add(new ContactData()
              .withId(id)
              .withFirstName(firstname)
              .withMiddleName(null)
              .withLastName(lastname)
              .withNickName(null)
              .withTitle(null)
              .withCompany(null)
              .withAddress(address)
              .withAllPhones(allPhones)
              .withFaxPhone(null)
              .withAllEmails(allEmails)
              .withGroup(null));
    }
    return contacts;
  }

  private Contacts contactCache = null;

  public Contacts all() {
      if (contactCache != null) {
        return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String address = cells.get(3).getText();
      String allEmails = cells.get(4).getText();;
      String allPhones = cells.get(5).getText();

      contactCache.add(new ContactData()
              .withId(id)
              .withFirstName(firstname)
              .withMiddleName(null)
              .withLastName(lastname)
              .withNickName(null)
              .withTitle(null)
              .withCompany(null)
              .withAddress(address)
              .withAllPhones(allPhones)
              .withFaxPhone(null)
              .withAllEmails(allEmails)
              .withGroup(null)
      )
      ;
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModification(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email1 = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData()
            .withId(contact.getId())
            .withFirstName(firstname)
            .withMiddleName(null)
            .withLastName(lastname)
            .withNickName(null)
            .withTitle(null)
            .withCompany(null)
            .withAddress(address)
            .withHomePhone(home)
            .withMobilePhone(mobile)
            .withWorkPhone(work)
            .withFaxPhone(null)
            .withEmail1(email1)
            .withEmail2(email2)
            .withEmail3(email3)
            .withGroup(null)
            ;
  }

  private void initContactModificationId(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }
}





