package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().returnToHomePage();
    int before = app.getContactHelper().getContactCount();
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
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
  }
}
