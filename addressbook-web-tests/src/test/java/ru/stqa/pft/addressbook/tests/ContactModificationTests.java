package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
public class ContactModificationTests extends TestBase {

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

  @Test // (enabled = false)
  public void testContactModification() {
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() - 1;
    ContactData contact = new ContactData(before.get(index).getId(),
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
    app.getContactHelper().modifyContact(index, contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}