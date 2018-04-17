package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().homePage();
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


      @Test
      public void testContactDeletion () {
        Set<ContactData> before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(deletedContact);
        Assert.assertEquals(before, after);
      }

}