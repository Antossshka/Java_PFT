package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  public final String firstname;
  public final String middlename;
  public final String lastname;
  public final String mobile;
  public final String email;
  public final String address;
  private String group;
  private int id;

  public ContactData(String firstname, String middlename, String lastname, String mobile, String email, String address, String group) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.mobile = mobile;
    this.email = email;
    this.address = address;
    this.group = group;
    this.id = Integer.MAX_VALUE;
  }

  public ContactData(String firstname, String middlename, String lastname, String mobile, String email, String address, String group, int id) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.mobile = mobile;
    this.email = email;
    this.address = address;
    this.group = group;
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getMobile() {
    return mobile;
  }

  public String getEmail() {
    return email;
  }

  public String getAddress() {
    return address;
  }

  public String getGroup() {
    return group;
  }

  public int getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname, id);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", id=" + id +
            '}';
  }

  public void setID(int id) {
    this.id = id;
  }
}