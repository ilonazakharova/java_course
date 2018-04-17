package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData()
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
              .withGroup("test1"));
    }

  }

  @Test // (enabled = false)
  public void testContactModification() {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId())
            .withFirstName("Ilona")
            .withMiddleName(null)
            .withLastName("Zakharova")
            .withNickName(null)
            .withTitle(null)
            .withCompany(null)
            .withAddress("Belarus, Gomel")
            .withHomePhone("+0123456789")
            .withMobilePhone("+012345678")
            .withWorkPhone("+01234567")
            .withFaxPhone(null)
            .withEmail1("email1@email.com")
            .withEmail2("email2@email.com")
            .withEmail3("email3@email.com")
            .withGroup("test1");

    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);

  }

}