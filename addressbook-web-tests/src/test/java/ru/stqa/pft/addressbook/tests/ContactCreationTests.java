package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test //(enabled = false)
  public void testContactCreation() {
    app.contact().homePage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData(
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
            "test1");
    app.contact().create(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}