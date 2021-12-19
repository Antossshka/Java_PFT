package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String homePhoneNumber;
  private final String email;
  private final String firstName;
  private final String secondName;
  private String group;

  public ContactData(String homePhoneNumber, String email, String firstName, String secondName, String group) {
    this.homePhoneNumber = homePhoneNumber;
    this.email = email;
    this.firstName = firstName;
    this.secondName = secondName;
    this.group = group;
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
}
