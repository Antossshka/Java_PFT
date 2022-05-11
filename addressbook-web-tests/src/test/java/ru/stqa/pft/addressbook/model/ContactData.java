package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String homePhoneNumber;
  private final String email;
  private final String firstName;
  private final String secondName;
  private String group;
  private int id;

  public ContactData(String homePhoneNumber, String email, String firstName, String secondName, String group) {
    this.homePhoneNumber = homePhoneNumber;
    this.email = email;
    this.firstName = firstName;
    this.secondName = secondName;
    this.group = group;
    this.id = Integer.MAX_VALUE;
  }

  public ContactData(String homePhoneNumber, String email, String firstName, String secondName, String group, int id) {
    this.homePhoneNumber = homePhoneNumber;
    this.email = email;
    this.firstName = firstName;
    this.secondName = secondName;
    this.group = group;
    this.id = id;
  }

  public String getHomePhoneNumber() {
    return homePhoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public String getGroup() {
    return group;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstName='" + firstName + '\'' +
            ", secondName='" + secondName + '\'' +
            ", id='" + id + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstName, that.firstName) &&
            Objects.equals(secondName, that.secondName) &&
            Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, secondName, id);
  }

  public void setID(int id) {
    this.id = id;
  }
}
