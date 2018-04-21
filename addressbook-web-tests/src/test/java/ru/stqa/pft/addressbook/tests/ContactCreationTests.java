package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test (enabled = false)
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
            .withPhoto(photo)
            ;
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo
            (before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }


  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(";");
      list.add(new Object[] {new ContactData()
              .withFirstName(split[0])
              .withMiddleName(split[1])
              .withLastName(split[2])
              .withNickName(split[3])
              .withTitle(split[4])
              .withCompany(split[5])
              .withAddress(split[6])
              .withHomePhone(split[7])
              .withMobilePhone(split[8])
              .withWorkPhone(split[9])
              .withFaxPhone(split[10])
              .withEmail1(split[11])
              .withEmail2(split[12])
              .withEmail3(split[13])
              .withGroup(split[14])
      });
      line = reader.readLine();
    }
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