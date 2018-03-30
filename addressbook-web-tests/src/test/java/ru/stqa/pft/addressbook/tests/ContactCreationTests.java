package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    gotoContactPage();
    contactHelper.fillContactForm(new ContactData("Fname", "Middle name", "Last name", "nickname", "title", "company", "address", "+123456789", "+12345678", "+1234567", "+123456", "email1@email.com", "email2@email.com", "email3@email.com"));
    contactHelper.submitContactCreation();
    contactHelper.returnToHomePage();
  }

}
