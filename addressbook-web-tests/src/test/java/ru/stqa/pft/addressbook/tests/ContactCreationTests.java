package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class ContactCreationTests extends TestBase{

  @Test(enabled = false)
  public void testAddContact() throws Exception {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoAddNewPage();
    ContactData contact = new ContactData("89994445566","boris.petrov@mail.ru","Boris", "Petrov", "[none]");
    app.getContactHelper().createContact(contact);
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    app.getSessionHelper().logout();

    Assert.assertEquals(after.size(), before.size() + 1);

    contact.setID(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byID = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byID);
    after.sort(byID);
    Assert.assertEquals(before, after);
  }

}
