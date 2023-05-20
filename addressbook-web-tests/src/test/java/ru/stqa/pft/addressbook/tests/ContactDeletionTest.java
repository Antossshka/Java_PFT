package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions () {
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Dmitry").withLastname("Blinovsky").withMiddlename("Petrov")
              .withMobile("89991112299").withEmail("petrov.db@mail.ru").withAddress("Mowcow").withGroup("test1"));
    }
  }

  @Test(enabled = true)
  public void testContactDeletion() throws Exception {
    app.goTo().homePage();
    ensurePreconditions();
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app().contact().count(), equalTo(before.size() - 1));
    Contacts after = app.contact().all();

    before.remove(deletedContact);
    assertThat(after, equalTo(before.withOut(deletedContact)));
  }



}
