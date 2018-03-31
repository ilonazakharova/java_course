package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
      app.getContactHelper().returnToHomePage();
      app.getContactHelper().selectContact();
      app.getContactHelper().deleteSelectedContacts();
      app.getContactHelper().closeWindow();
      app.getContactHelper().returnToHomePage();
    }

}
