package ru.stqa.pft.addressbook.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

import static org.openqa.selenium.By.name;

public class HbConnectionTest extends TestBase{
  private SessionFactory sessionFactory;

  @BeforeClass
  protected void initSessionFactory() throws Exception {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    try {
      sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }
    catch (Exception e) {
      e.printStackTrace(); //вывод сообщения об ошибке на консоль
      // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
      // so destroy it manually.
      StandardServiceRegistryBuilder.destroy( registry );
    }
  }

  @Test
  public void testHbConnection() {
    Session session = sessionFactory.openSession();
    //session.beginTransaction();
    List<ContactData> result = session.createQuery("from ContactData where deprecated = '0000-00-00'").list();
    for (ContactData contact : result) {
      // check group count
      List<GroupData> groupResult = session.createQuery("from GroupData").list();
      int numberOfGroups = groupResult.size();
      if(numberOfGroups == 0){
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("test1"));

        groupResult = updateGroupList(session);
      }

     // long numberAssignedGroups = getGroupCount(session, contact.getId());

      //if(numberAssignedGroups == numberOfGroups){
        //continue;
      //}

      int numbersGroupsAssignedOnContact = contact.getGroups().size();
      if(numbersGroupsAssignedOnContact == numberOfGroups){
        continue;
      }

      if(numbersGroupsAssignedOnContact == 0){
        GroupData groupData = groupResult.get(0);
        //contact.getGroups().add(groupData);
        //session.save(contact);
        addContactInGroup(contact.getId(), groupData.getId()); // getId - add xpath
      }else {
        for (GroupData groupData : groupResult) {
          if(!contact.getGroups().contains(groupData)){
            //contact.getGroups().add(groupData);
            //session.save(contact);
            addContactInGroup(contact.getId(), groupData.getName()); //вот это мне нужно реализовать с помощью xpath и новых степов с главной страницы, где находятся контакты
            break;
          }
        }
      }


      //System.out.println(contact);
      //System.out.println(contact.getGroups()); //в какие группы входит контакт
    }
    //session.getTransaction().commit();
    session.close();

  }

  private void addContactInGroup(int contactId
          , int groupDataId) {
      new Select(wd.findElement(name("to_group"))).selectByValue(groupDataId);
  }

  private List<GroupData> updateGroupList(Session session) {
    List<GroupData> groupResult;
    session.beginTransaction();
    groupResult = session.createQuery("from GroupData").list();
    session.getTransaction().commit();
    return groupResult;
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




//1. Получить список всех контактов +
// 2. Проверить есть ли хотя бы 1 группа - cм groupcreationtest, если нет, то группу создала
// 3.1. Контакт не добавлени ни в одну группу - нет связи с группой -> добавить в любую группу
// 3.2. Контакт добавлен в группу, берем следующую, до тех пор пока не закончится список групп


//1. Берем любой контакт, проверяем есть ли группа у него
// 1.1. если есть - до мы должны удалить эту группу
// 1.2. если группы у контакта нет - нам нужно взять другой контакт
// 1.2.1. если группы у контакта нет - создать группу, добавить контакт в эту группу, потом удалить эту группу из  контакта