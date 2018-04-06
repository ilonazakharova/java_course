package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
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


  public ContactData(String FirstName,
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
    firstName = FirstName;
    middleName = MiddleName;
    lastName = LastName;
    nickName = NickName;
    title = Title;
    company = Company;
    address = Address;
    homePhone = HomePhone;
    mobilePhone = MobilePhone;
    workPhone = WorkPhone;
    faxPhone = FaxPhone;
    email1 = Email1;
    email2 = Email2;
    email3 = Email3;
    this.group = group;
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

  public String getEmail3() { return email3; }

  public String getGroup() { return group; }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(address, that.address) &&
            Objects.equals(homePhone, that.homePhone) &&
            Objects.equals(mobilePhone, that.mobilePhone) &&
            Objects.equals(workPhone, that.workPhone) &&
            Objects.equals(email1, that.email1) &&
            Objects.equals(email2, that.email2) &&
            Objects.equals(email3, that.email3);
  }

  @Override
  public int hashCode() {

    return Objects.hash(firstName, lastName, address, homePhone, mobilePhone, workPhone, email1, email2, email3);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "lastName='" + lastName + '\'' +
            '}';
  }
}
