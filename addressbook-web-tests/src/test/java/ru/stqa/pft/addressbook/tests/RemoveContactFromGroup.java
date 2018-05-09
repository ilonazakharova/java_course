package ru.stqa.pft.addressbook.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import java.util.List;
import java.util.stream.Collectors;
import static org.openqa.selenium.By.cssSelector;

public class RemoveContactFromGroup extends TestBase {
  private SessionFactory sessionFactory;

  @BeforeClass
  protected void initSessionFactory() throws Exception {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    try {
      sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    } catch (Exception e) {
      e.printStackTrace(); //вывод сообщения об ошибке на консоль
      // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
      // so destroy it manually.
      StandardServiceRegistryBuilder.destroy(registry);
    }
  }

  @Test
  public void testDeleteContactFromGroup() {
    Session session = sessionFactory.openSession();
    //1. получить список групп, у которых есть хотя бы 1 контакт
    List<GroupData> groupResult = session.createQuery("from GroupData").list();
    groupResult = groupResult.stream().filter(group -> group.getContacts().size() > 0).collect(Collectors.toList());
    // 2. взять первую группу с контактом, для того, чтобы потом контакт удалить
    if (!groupResult.isEmpty()) {
      GroupData groupWithContact = groupResult.get(0);
      app.contact().click(By.xpath("//form[@id='right']")); //выбор группы, в которой есть контакт, навигация, главная страинца с контактами
      app.contact().click(By.xpath("//form[@id='right']/select[@name='group']/option[@value='" + groupWithContact.getId() + "']")); //открылось выпадающее меню, из него выбираем группу по айдишнику
      //  List<ContactData> arrayList = new ArrayList<ContactData>(groupWithContact.getContactsSet());
      // ContactData contactData = arrayList.get(0);
      ContactData contactData = null;
      if (groupWithContact.getContactsSet().iterator().hasNext()) {
        contactData = groupWithContact.getContactsSet().iterator().next();
      }

      if (contactData != null) {
        app.contact().click(cssSelector(String.format("input[id='%s']", contactData.getId())));
      }
      app.contact().click(By.xpath("//input[@name='remove']"));
    } else {
      //1) есть группы, нет контактов в группах

      // 2) нет групп и нет контактов
      List<ContactData> result = session.createQuery("from ContactData where deprecated = '0000-00-00'").list();

      if (result.size() == 0) {
        app.goTo().contactPage();
        app.contact().create(new ContactData().withFirstName("First Contact"));
        result = updateContactList(session);
      }

      for (ContactData contact : result) {
        // check group count
        groupResult = session.createQuery("from GroupData").list();
        int numberOfGroups = groupResult.size();
        if (numberOfGroups == 0) {
          app.goTo().groupPage();
          app.group().create(new GroupData().withName("test1"));
          groupResult = updateGroupList(session);
        }

        int numbersGroupsAssignedOnContact = contact.getGroups().size();
        if (numbersGroupsAssignedOnContact == numberOfGroups) {
          continue;
        }


        if (numbersGroupsAssignedOnContact == 0) {
          GroupData groupData = groupResult.get(0);
          addContactInGroup(contact.getId(), groupData.getId()); // getId - add xpath
          groupResult = updateGroupList(session);
        } else {
          for (GroupData groupData : groupResult) {
            if (!contact.getGroups().contains(groupData)) {
              addContactInGroup(contact.getId(), groupData.getId()); //вот это мне нужно реализовать с помощью xpath и новых степов с главной страницы, где находятся контакты
              break;
            }
          }
        }


        // deletion
        GroupData groupWithContact = groupResult.get(0);
        app.contact().click(By.xpath("//form[@id='right']")); //выбор группы, в которой есть контакт, навигация, главная страинца с контактами
        app.contact().click(By.xpath("//form[@id='right']/select[@name='group']/option[@value='" + groupWithContact.getId() + "']")); //открылось выпадающее меню, из него выбираем группу по айдишнику
        //  List<ContactData> arrayList = new ArrayList<ContactData>(groupWithContact.getContactsSet());
        // ContactData contactData = arrayList.get(0);
        ContactData contactData = null;
        if (groupWithContact.getContactsSet().iterator().hasNext()) {
          contactData = groupWithContact.getContactsSet().iterator().next();
        }

        if (contactData != null) {
          app.contact().click(cssSelector(String.format("input[id='%s']", contactData.getId())));
          app.contact().click(By.xpath("//input[@name='remove']"));
        }
      }
    }
  }



  private void addContactInGroup(int contactId, int groupDataId) {
    app.goTo().contactPage();
    app.contact().click(cssSelector(String.format("input[id='%s']", contactId))); //выбираю контакт с произвольным id
    app.contact().click(By.xpath("//select[@name='to_group']")); // список групп
    app.contact().click(By.xpath("//select[@name='to_group']/option[@value='" + groupDataId + "']")); // выбор случайной группы по id
    app.contact().click(By.xpath("//input[@value='Add to']"));  //подтверждаем добавление контакта в группу
  }


  private List<GroupData> updateGroupList(Session session) {
    List<GroupData> groupResult;
    session.beginTransaction();
    groupResult = session.createQuery("from GroupData").list();
    session.getTransaction().commit();
    return groupResult;
  }


  private List<ContactData> updateContactList(Session session) {
    List<ContactData> contactResult;
    session.beginTransaction();
    contactResult = session.createQuery("from ContactData where deprecated = '0000-00-00'").list();
    session.getTransaction().commit();
    return contactResult;
  }

  private long getGroupCount(Session session, int contactId) {
    NativeQuery nativeQuery = session.createNativeQuery("select count(*) from address_in_groups aig\n" +
            "join addressbook ab on ab.id = aig.id\n" +
            "join group_list gl on gl.group_id = aig.group_id\n" +
            "where aig.id = :contactId");
    nativeQuery.setParameter("contactId", contactId);
    return (long) nativeQuery.getSingleResult();
  }


}

// 0. Добавить проверку на то, что если нет контакта, то его нужно создать - добавить еще эту проверку
//1. Получить список всех контактов + +
// 2. Проверить есть ли хотя бы 1 группа - cм groupcreationtest, если нет, то группу создала
// 3.1. Контакт не добавлени ни в одну группу - нет связи с группой -> добавить в любую группу
// 3.2. Контакт добавлен в группу, берем следующую, до тех пор пока не закончится список групп


//1. Берем любой контакт, проверяем есть ли группа у него
// 1.1. если есть - до мы должны удалить эту группу
// 1.2. если группы у контакта нет - нам нужно взять другой контакт
// 1.2.1. если группы у контакта нет - создать группу, добавить контакт в эту группу, потом удалить эту группу из  контакта +

