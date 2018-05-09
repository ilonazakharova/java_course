package ru.stqa.pft.mantis.model;

public class UserInformation {

  private String username;
  private String email;

  public String getUserName() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public UserInformation withUsername(String name) {
    this.username = name;
    return this;
  }

  public UserInformation withEmail(String email) {
    this.email = email;
    return this;
  }

}
