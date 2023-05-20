package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions () {
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Dmitry").withLastname("Blinovsky").withMiddlename("Petrov")
              .withMobile("89991112299").withEmail("petrov.db@mail.ru").withAddress("Mowcow").withGroup("test1"));
    }
  }

  @Test(enabled = true)
  public void testContactModification() {
    app.goTo().homePage();
    ensurePreconditions();
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withFirstname("Dmitry").withLastname("Petrov").withId(modifiedContact.getId());
    app.contact().modify(contact);
    assertThat(app().contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();

    MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.withOut(modifiedContact).withAdded(contact)));
  }


}
