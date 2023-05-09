package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test(enabled = false)
  public void testContactCreation() throws Exception {
    app.goTo().gotoHomePage();
    ContactData contact = new ContactData("Dmitry", null, "Petrov", null, null, null, null);
    List<ContactData> before = app.contactHelper().getContactList();
    app.contactHelper().createContact(new ContactData("Dmitry", "Blinovsky", "Petrov", "89991112299", "petrov.db@mail.ru", "Mowcow", "test1"));
    List<ContactData> after = app.contactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.setID(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}


