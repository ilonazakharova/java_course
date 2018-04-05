package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {



  @Test
  public void testContactModification () {
    app.getContactHelper().returnToHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Ilona",
            "Middle name",
            "Zakharova",
            "nickname",
            "title",
            "company",
            "Belarus, Minsk",
            "+123456789",
            "+12345678",
            "+1234567",
            "+123456",
            "email1@email.com",
            "email2@email.com",
            "email3@email.com",
            null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }


}
