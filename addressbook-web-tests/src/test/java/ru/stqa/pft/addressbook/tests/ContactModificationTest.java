package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase{

  @Test
  public void testContactModification() {
    app.navigationHelper().gotoHomePage();
    app.contactHelper().selectContact();
    app.contactHelper().initContactModification();
    app.contactHelper().fillContactForm(new ContactData("Dmitry1", "Blinovsky2", "Petrov3", "89991112299", "petrov.db@mail.ru", "Mowcow"));
    app.contactHelper().submitContactModification();
    app.contactHelper().returnToHomePage();
  }
}
