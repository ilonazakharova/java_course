package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification () {
    contactHelper.returnToHomePage();
    contactHelper.selectContact();
    contactHelper.initContactModifitaction();
    contactHelper.fillContactForm(new ContactData("Fname", "Middle name", "Last name", "nickname", "title", "company", "address", "+123456789", "+12345678", "+1234567", "+123456", "email1@email.com", "email2@email.com", "email3@email.com"));
    contactHelper.submitContactModification();
    contactHelper.returnToHomePage();
  }
}
