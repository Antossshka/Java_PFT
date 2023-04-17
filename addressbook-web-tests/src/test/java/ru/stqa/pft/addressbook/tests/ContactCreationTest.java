package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.contactHelper().initContactCreation();
    app.contactHelper().fillContactForm(new ContactData("Dmitry", "Blinovsky", "Petrov", "89991112299", "petrov.db@mail.ru", "Mowcow"));
    app.contactHelper().submitContactCreation();
    app.contactHelper().returnToHomePage();
  }

}
