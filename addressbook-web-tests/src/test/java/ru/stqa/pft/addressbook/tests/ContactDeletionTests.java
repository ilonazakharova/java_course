package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.ContactHelper;

public class ContactDeletionTests extends TestBase {

    
    @Test
    public void testContactDeletion() {
       contactHelper.returnToHomePage();
       contactHelper.selectContact();
       contactHelper.deleteSelectedContacts();
       contactHelper.closeWindow();
       contactHelper.returnToHomePage();
    }

}
