package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactCreationTests extends TestBase{

  @Test
  public void testAddContact() throws Exception {
    app.getNavigationHelper().gotoAddNewPage();
    app.getContactHelper().createContact(new ContactData("89994445566","boris.petrov@mail.ru","Boris", "Petrov", "[none]"));
    app.getNavigationHelper().gotoHomePage();
    app.getSessionHelper().logout();
  }

}
