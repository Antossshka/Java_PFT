package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase{

  @Test
  public void testContactModification() {
    app.navigationHelper().gotoHomePage();
    if (! app.contactHelper().isThereAContact()) {
      app.contactHelper().createContact(new ContactData("Dmitry", "Blinovsky", "Petrov", "89991112299", "petrov.db@mail.ru", "Moscow", "test1"));
    }
    List<ContactData> before = app.contactHelper().getContactList();
    app.contactHelper().initContactModification(before.size()-1);
    app.contactHelper().fillContactForm(new ContactData("Dmitry1", "Blinovsky2", "Petrov3", "89991112299", "petrov.db@mail.ru", "Moscow", null), false);
    app.contactHelper().submitContactModification();
    app.contactHelper().returnToHomePage();
    List<ContactData> after = app.contactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size());

    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    ContactData contact = new ContactData("Dmitry1", null, "Petrov3", null, null, null, null, before.get(before.size()-1).getId());

    before.remove(before.size()-1);
    before.add(contact);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
