package ru.stqa.pft.addressbook.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  public Iterator<Object[]> validContactsFromXml() throws IOException {
    try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactData.class);
      List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
      return contacts.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();

      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {}.getType()); //List<ContactData>.class();
      return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
    }
  }

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().contactPage();
      app.contact().create(new ContactData()
                      .withFirstName("Ilona")
                      .withMiddleName(null)
                      .withLastName("Zakharova")
                      .withNickName("")
                      .withTitle("")
                      .withCompany("")
                      .withAddress("Belarus, Minsk")
                      .withHomePhone("+123456789")
                      .withMobilePhone("+12345678")
                      .withWorkPhone("+1234567")
                      .withFaxPhone("")
                      .withEmail1("email1@email.com")
                      .withEmail2("email2@email.com")
                      .withEmail3("email3@email.com")
                      //.withGroup(null)
      );
    }
  }

  @Test(dataProvider = "validContactsFromJson")
  public void testContactCreation(ContactData contact) {
    app.goTo().contactPage();
    Contacts before = app.db().contacts();
    app.contact().create(contact);
    Contacts after = app.db().contacts();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test(enabled = false)
  public void testContactCreation() {
    app.contact().homePage();
    Contacts before = app.db().contacts();
    File photo = new File("src/test/resources/photo.jpg");
    ContactData contact = new ContactData()
          .withFirstName("Ilona")
          .withMiddleName("")
          .withLastName("Zakharova")
          .withNickName("")
          .withTitle("")
          .withCompany("")
          .withAddress("Belarus, Minsk")
          .withHomePhone("+123456789")
          .withMobilePhone("+12345678")
          .withWorkPhone("+1234567")
          .withFaxPhone("")
          .withEmail1("email1@email.com")
          .withEmail2("email2@email.com")
          .withEmail3("email3@email.com")
          //.withGroup("test1")
          //.withPhoto(photo)
          ;
    app.goTo().contactPage();
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo
           (before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    verifyContactListInUI();
    }

  @Test (enabled = false)
  public void testBadContactCreation() {
    app.contact().homePage();
    Contacts before = app.db().contacts();
    ContactData contact = new ContactData()
            .withFirstName("Ilona'")
            .withMiddleName("")
            .withLastName("Zakharova")
            .withNickName("")
            .withTitle("")
            .withCompany("")
            .withAddress("Belarus, Minsk")
            .withHomePhone("+123456789")
            .withMobilePhone("+12345678")
            .withWorkPhone("+1234567")
            .withFaxPhone("")
            .withEmail1("email1@email.com")
            .withEmail2("email2@email.com")
            .withEmail3("email3@email.com")
            //.withGroup("test1")
    ;
    app.goTo().contactPage();
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before));
    verifyContactListInUI();
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
