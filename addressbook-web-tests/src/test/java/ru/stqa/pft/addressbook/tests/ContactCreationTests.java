package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactCreationTests extends TestBase{

  @Test
  public void testAddContact() throws Exception {
    int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().gotoAddNewPage();
    app.getContactHelper().createContact(new ContactData("89994445566","boris.petrov@mail.ru","Boris", "Petrov", "[none]"));
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    app.getSessionHelper().logout();

    Assert.assertEquals(after, before + 1);
  }

}
