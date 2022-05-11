package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion() throws Exception{
    int before = app.getContactHelper().getContactCount();
    if (! app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoAddNewPage();
      app.getContactHelper().createContact(new ContactData("89994445566","boris.petrov@mail.ru","Boris", "Petrov", "[none]"));
    }
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact(0);
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().alertAccept();
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    app.getSessionHelper().logout();

    Assert.assertEquals(after, before - 1);

  }

}
