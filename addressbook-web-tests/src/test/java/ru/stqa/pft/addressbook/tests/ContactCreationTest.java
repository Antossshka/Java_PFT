package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.contactHelper().initContactCreation();
    if (! app.contactHelper().isThereAnAvailableGroup(new ContactData("Dmitry", "Blinovsky", "Petrov", "89991112299", "petrov.db@mail.ru", "Mowcow", "test1"), true)); {
      app.navigationHelper().gotoGroupPage();
      app.groupHelper().createGroup(new GroupData("test1", null, null));
    }
  }

}
