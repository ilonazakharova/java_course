package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
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
  }

  @Test  //(enabled = false)
    public void testContactDeletion() {
      List<ContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().selectContact (before.size() - 1);
      app.getContactHelper().deleteSelectedContacts();
      app.getContactHelper().closeWindow();
      app.getContactHelper().returnToHomePage();
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size() - 1);
      before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }

}
