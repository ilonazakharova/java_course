package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
      app.getContactHelper().returnToHomePage();
      if (! app.getContactHelper().isThereAContact()) {
        app.getContactHelper().createContact(new ContactData( "Ilona",
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

      app.getContactHelper().selectContact();
      app.getContactHelper().deleteSelectedContacts();
      app.getContactHelper().closeWindow();
      app.getContactHelper().returnToHomePage();
    }

}
