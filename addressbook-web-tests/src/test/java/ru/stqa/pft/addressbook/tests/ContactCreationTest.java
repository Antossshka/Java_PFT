package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTest extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() throws Exception {
    app.goTo().homePage();
    ContactData contact = new ContactData().withFirstname("Dmitry").withLastname("Blinovsky");
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/photo.PNG");
    app.contact().create(new ContactData().withFirstname("Dmitry").withLastname("Blinovsky").withMiddlename("Petrov")
            .withMobile("89991112299").withEmail("petrov.db@mail.ru").withAddress("Mowcow").withGroup("test1").withPhoto(photo));
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after,
            equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test(enabled = false)
  public void testBadContactCreation() throws Exception {
    app.goTo().homePage();
    ContactData contact = new ContactData().withFirstname("Dmitry'").withLastname("Blinovsky");
    Contacts before = app.contact().all();
    app.contact().create(new ContactData().withFirstname("Dmitry'").withLastname("Blinovsky").withMiddlename("Petrov")
            .withMobile("89991112299").withEmail("petrov.db@mail.ru").withAddress("Mowcow").withGroup("test1"));
    assertThat(app().contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }

  @Test
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/photo.PNG");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
}


