package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTest extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() throws Exception {
    app.goTo().homePage();
    ContactData contact = new ContactData().withFirstname("Dmitry").withLastname("Blinovsky");
    Contacts before = app.contact().all();
    app.contact().create(new ContactData().withFirstname("Dmitry").withLastname("Blinovsky").withMiddlename("Petrov")
            .withMobile("89991112299").withEmail("petrov.db@mail.ru").withAddress("Mowcow").withGroup("test1"));
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after,
            equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}


