package ru.stqa.pft.mantis.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "mantis_user_table")


public class UserInformation {
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Column(name = "username")
  private String username;

  @Column(name = "email")
  private String email;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserInformation that = (UserInformation) o;
    return Objects.equals(username, that.username) &&
            Objects.equals(email, that.email);
  }

  @Override
  public int hashCode() {

    return Objects.hash(username, email);
  }

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
