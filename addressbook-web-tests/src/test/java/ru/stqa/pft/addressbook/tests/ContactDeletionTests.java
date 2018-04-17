package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.without(deletedContact)));
      }
}