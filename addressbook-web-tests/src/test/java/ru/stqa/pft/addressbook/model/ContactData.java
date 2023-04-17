package ru.stqa.pft.addressbook.model;

public class ContactData {
  public final String firstname;
  public final String middlename;
  public final String lastname;
  public final String mobile;
  public final String email;
  public final String address;
  public ContactData(String firstname, String middlename, String lastname, String mobile, String email, String address) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.mobile = mobile;
    this.email = email;
    this.address = address;
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
}