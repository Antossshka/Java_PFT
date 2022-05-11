package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoAddNewPage();
      app.getContactHelper().createContact(new ContactData("89994445566","boris.petrov@mail.ru","Boris", "Petrov", "[none]"));
    }
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification(before.size() - 1);
    ContactData contact = new ContactData("89526452646","oleg.fedorov@mail.ru","Oleg", "Fedorov", null, before.get(before.size() - 1).getId());
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    app.getSessionHelper().logout();

    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byID = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byID);
    after.sort(byID);
    Assert.assertEquals(before, after);
  }
}
