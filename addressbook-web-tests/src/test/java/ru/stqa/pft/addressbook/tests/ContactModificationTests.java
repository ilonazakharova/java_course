package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().contactPage();
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
              //.withGroup(null)
      );
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId())
            .withFirstName("Ilona")
            .withMiddleName("")
            .withLastName("Zakharova")
            .withNickName("")
            .withTitle("")
            .withCompany("")
            .withAddress("Belarus, Gomel")
            .withHomePhone("0123456789")
            .withMobilePhone("012345678")
            .withWorkPhone("01234567")
            .withFaxPhone("")
            .withEmail1("email1@email.com")
            .withEmail2("email2@email.com")
            .withEmail3("email3@email.com")
            //.withGroup("")
            ;
    app.goTo().contactPage();
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, CoreMatchers.equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}