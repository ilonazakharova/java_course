package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@XStreamAlias("group")
@Entity
@Table(name = "group_list")
public class GroupData {
  @XStreamOmitField
  @Id
  @Column(name = "group_id")
  private int id = Integer.MAX_VALUE;;

  @Expose
  @Column(name = "group_name")
  @Type(type = "text")
  private String name;

  @Expose
  @Column(name = "group_header")
  @Type(type = "text")
  private String header;

  @Expose
  @Column(name = "group_footer")
  @Type(type = "text")
  private String footer;

  public int getId() {
    return id;
  }

  public GroupData withId(int id) {
    this.id = id;
    return this;
  }


  public GroupData withName(String name) {
    this.name = name;
    return this;
  }

  public GroupData withHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;
  }


  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;

    if (id != groupData.id) return false;
    if (name !=null ? !name.equals(groupData.name) : groupData.name != null) return false;
    if (header !=null ? !header.equals(groupData.header) : groupData.header != null) return false;
    return footer != null ? footer.equals(groupData.footer) : groupData.footer == null;

    //return id == groupData.id &&
            //Objects.equals(name, groupData.name) &&
            //Objects.equals(header, groupData.header) &&
            //Objects.equals(footer, groupData.footer);
  }

  @Override
  public int hashCode() {
  int result = id;
  result = 31 * result + (name != null ? name.hashCode() : 0);
  result = 31 * result + (header != null ? name.hashCode() : 0);
  result = 31 * result + (footer != null ? name.hashCode() : 0);
    //return Objects.hash(id, name, header, footer);
    return result;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", header='" + header + '\'' +
            ", footer='" + footer + '\'' +
            '}';
  }

}
