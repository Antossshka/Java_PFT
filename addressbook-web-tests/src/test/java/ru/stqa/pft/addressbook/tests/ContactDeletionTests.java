package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion() throws Exception{
    List<ContactData> before = app.getContactHelper().getContactList();
    if (! app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoAddNewPage();
      app.getContactHelper().createContact(new ContactData("89994445566","boris.petrov@mail.ru","Boris", "Petrov", "[none]"));
    }
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact(0);
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().alertAccept();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    app.getSessionHelper().logout();

    Assert.assertEquals(after.size(), before.size() - 1);

  }

}
