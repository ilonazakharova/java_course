package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    
    @Test
    public void testContactDeletion() {
       contactHelper.returnToHomePage();
       contactHelper.selectContact();
       contactHelper.deleteSelectedContacts();
       contactHelper.returnToHomePage();
    }

}
