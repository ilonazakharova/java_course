package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test //(enabled = false)
  public void testContactCreation() {
    app.contact().homePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/photo.jpg");
    ContactData contact = new ContactData()
            .withFirstName("Ilona")
            .withMiddleName(null)
            .withLastName("Zakharova")
            .withNickName(null)
            .withTitle(null)
            .withCompany(null)
            .withAddress("Belarus, Minsk")
            .withHomePhone("+123456789")
            .withMobilePhone("+12345678")
            .withWorkPhone("+1234567")
            .withFaxPhone(null)
            .withEmail1("email1@email.com")
            .withEmail2("email2@email.com")
            .withEmail3("email3@email.com")
            .withGroup("test1")
            .withPhoto(photo);
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo
            (before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @DataProvider
  public Iterator<Object[]> validContacts() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new ContactData()
            .withFirstName("Ilona")
            .withMiddleName(null)
            .withLastName("Zakharova")
            .withNickName(null)
            .withTitle(null)
            .withCompany(null)
            .withAddress("Belarus, Minsk")
            .withHomePhone("+123456789")
            .withMobilePhone("+12345678")
            .withWorkPhone("+1234567")
            .withFaxPhone(null)
            .withEmail1("email1@email.com")
            .withEmail2("email2@email.com")
            .withEmail3("email3@email.com")
            .withGroup("test1")});
    list.add(new Object[] {new ContactData()
            .withFirstName("Tatiana")
            .withMiddleName(null)
            .withLastName("Zakharova")
            .withNickName(null)
            .withTitle(null)
            .withCompany(null)
            .withAddress("Belarus, Minsk")
            .withHomePhone("+123456789")
            .withMobilePhone("+12345678")
            .withWorkPhone("+1234567")
            .withFaxPhone(null)
            .withEmail1("email1@email.com")
            .withEmail2("email2@email.com")
            .withEmail3("email3@email.com")
            .withGroup("test1")});
    list.add(new Object[] {new ContactData()
            .withFirstName("Vladzimir")
            .withMiddleName(null)
            .withLastName("Zakharov")
            .withNickName(null)
            .withTitle(null)
            .withCompany(null)
            .withAddress("Belarus, Gomel")
            .withHomePhone("+123456789")
            .withMobilePhone("+12345678")
            .withWorkPhone("+1234567")
            .withFaxPhone(null)
            .withEmail1("email1@email.com")
            .withEmail2("email2@email.com")
            .withEmail3("email3@email.com")
            .withGroup("test1")});
    list.add(new Object[] {new ContactData()
            .withFirstName("Artem")
            .withMiddleName(null)
            .withLastName("Zakharov")
            .withNickName(null)
            .withTitle(null)
            .withCompany(null)
            .withAddress("Belarus, Gomel")
            .withHomePhone("+123456789")
            .withMobilePhone("+12345678")
            .withWorkPhone("+1234567")
            .withFaxPhone(null)
            .withEmail1("email1@email.com")
            .withEmail2("email2@email.com")
            .withEmail3("email3@email.com")
            .withGroup("test1")});
    return list.iterator();
  }

  @Test (dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) {
    app.goTo().contactPage();
    Contacts before = app.contact().all();
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test (enabled = false)
  public void testBadContactCreation() {
    app.contact().homePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstName("Ilona'")
            .withMiddleName(null)
            .withLastName("Zakharova")
            .withNickName(null)
            .withTitle(null)
            .withCompany(null)
            .withAddress("Belarus, Minsk")
            .withHomePhone("+123456789")
            .withMobilePhone("+12345678")
            .withWorkPhone("+1234567")
            .withFaxPhone(null)
            .withEmail1("email1@email.com")
            .withEmail2("email2@email.com")
            .withEmail3("email3@email.com")
            .withGroup("test1");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }

  @Test (enabled = false)
  public void testCurrentDir() {
    File CurrentDir = new File(".");
    System.out.println(CurrentDir.getAbsolutePath());
    File photo = new File("src/test/resources/photo.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
}