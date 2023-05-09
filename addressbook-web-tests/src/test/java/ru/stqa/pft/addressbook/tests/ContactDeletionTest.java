package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactDeletionTest extends TestBase {

  @Test(enabled = false)
  public void testContactDeletion() throws Exception {
    app.navigationHelper().gotoHomePage();
    ContactData contact = new ContactData("Dmitry", "Blinovsky", "Petrov", "89991112299", "petrov.db@mail.ru", "Moscow", "test1");
    if (! app.contactHelper().isThereAContact()) {
      app.contactHelper().createContact(new ContactData("Dmitry", "Blinovsky", "Petrov", "89991112299", "petrov.db@mail.ru", "Moscow", "test1"));
    }
    List<ContactData> before = app.contactHelper().getContactList();
    app.contactHelper().selectContact(0);
    app.contactHelper().deleteSelectedContacts();
    app.contactHelper().confirmDeletionContacts();
    app.contactHelper().returnToHomePage();
    List<ContactData> after = app.contactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    before.remove(0);
    Assert.assertEquals(before, after);
  }

}
