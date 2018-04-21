package ru.stqa.pft.addressbook.generators;
import ru.stqa.pft.addressbook.model.ContactData;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  public static void main (String[] agrs) throws IOException {
    int count = Integer.parseInt(agrs[0]);
    File file = new File(agrs[1]);
    List<ContactData> contacts = generateContacts(count);
    save(contacts, file);
  }

  private static void save(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsoluteFile());
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format(
              "%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;\n",
              contact.getFirstName(),
              contact.getMiddleName(),
              contact.getLastName(),
              contact.getNickName(),
              contact.getTitle(),
              contact.getCompany(),
              contact.getAddress(),
              contact.getHomePhone(),
              contact.getMobilePhone(),
              contact.getWorkPhone(),
              contact.getFaxPhone(),
              contact.getEmail1(),
              contact.getEmail2(),
              contact.getEmail3(),
              contact.getGroup(),
              contact.getPhoto()));
    }
    writer.close();
  }

  private static List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData()
              .withFirstName(String.format("FirstName %s", i))
              .withMiddleName(String.format("%s", i))
              .withLastName(String.format("Zakharova %s", i))
              .withNickName(String.format("%s", i))
              .withTitle(String.format("%s", i))
              .withCompany(String.format("%s", i))
              .withAddress(String.format("Belarus, Minsk %s", i))
              .withHomePhone(String.format("+123456789 %s", i))
              .withMobilePhone(String.format("+12345678 %s", i))
              .withWorkPhone(String.format("+1234567 %s", i))
              .withFaxPhone(String.format("%s", i))
              .withEmail1(String.format("email1@email.com %s", i))
              .withEmail2(String.format("email2@email.com %s", i))
              .withEmail3(String.format("email3@email.com %s", i))
              .withGroup(String.format("test1 %s", i)));
    }
    return contacts;
  }
}

