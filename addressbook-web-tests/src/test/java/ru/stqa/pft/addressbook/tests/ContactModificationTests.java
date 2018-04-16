package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().returnToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData(
              "Ilona",
              null,
              "Zakharova",
              null,
              null,
              null,
              "Belarus, Minsk",
              "+123456789",
              "+12345678",
              "+1234567",
              null,
              "email1@email.com",
              "email2@email.com",
              "email3@email.com",
              "test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(),
            "Ilona",
            null,
            "Zakharova",
            null,
            null,
            null,
            "Belarus, Gomel",
            "+0123456789",
            "+012345678",
            "+01234567",
            null,
            "email1@email.com",
            "email2@email.com",
            "email3@email.com",
            "test1");
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }
}