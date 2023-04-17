package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tests.TestBase;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.initContactCreation();
    app.fillContactForm(new ContactData("Dmitry", "Blinovsky", "Petrov", "89991112299", "petrov.db@mail.ru", "Mowcow"));
    app.submitContactCreation();
    app.gotoHomePage();
  }

}
