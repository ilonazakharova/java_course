package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String nickName;
  private final String title;
  private final String company;
  private final String address;
  private final String homePhone;
  private final String mobilePhone;
  private final String workPhone;
  private final String faxPhone;
  private final String email1;
  private final String email2;
  private final String email3;
  private String group;

  public ContactData(
          String FirstName,
          String MiddleName,
          String LastName,
          String NickName,
          String Title,
          String Company,
          String Address,
          String HomePhone,
          String MobilePhone,
          String WorkPhone,
          String FaxPhone,
          String Email1,
          String Email2,
          String Email3,
          String group) {
    this.id = 0;
    this.firstName = FirstName;
    this.middleName = MiddleName;
    this.lastName = LastName;
    this.nickName = NickName;
    this.title = Title;
    this.company = Company;
    this.address = Address;
    this.homePhone = HomePhone;
    this.mobilePhone = MobilePhone;
    this.workPhone = WorkPhone;
    this.faxPhone = FaxPhone;
    this.email1 = Email1;
    this.email2 = Email2;
    this.email3 = Email3;
    this.group = group;

  }

  public ContactData(
          int id,
          String FirstName,
          String MiddleName,
          String LastName,
          String NickName,
          String Title,
          String Company,
          String Address,
          String HomePhone,
          String MobilePhone,
          String WorkPhone,
          String FaxPhone,
          String Email1,
          String Email2,
          String Email3,
          String group
  ) {
    this.id = id;
    this.firstName = FirstName;
    this.middleName = MiddleName;
    this.lastName = LastName;
    this.nickName = NickName;
    this.title = Title;
    this.company = Company;
    this.address = Address;
    this.homePhone = HomePhone;
    this.mobilePhone = MobilePhone;
    this.workPhone = WorkPhone;
    this.faxPhone = FaxPhone;
    this.email1 = Email1;
    this.email2 = Email2;
    this.email3 = Email3;
    this.group = group;

  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNickName() {
    return nickName;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getFaxPhone() {
    return faxPhone;
  }

  public String getEmail1() {
    return email1;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getGroup() {
    return group;
  }


  @Override
  public String toString() {

    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    return id == that.id &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName);
  }


  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }


  // @Override
  //public int hashCode() {
  //return Objects.hash(id, firstName, lastName);
  //}

}

