package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactFieldTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions () {
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Dmitry").withLastname("Blinovsky").withMiddlename("Petrov")
              .withMobilePhone("89991112299").withHomePhone("89991112292").withWorkPhone("89991112293")
              .withAddress("Mowcow").withGroup("test1")
              .withEmail("123@mail.ru").withEmail2("1234@m ail.ru").withEmail3("123@ma-il.ru"));
    }
  }

  @Test
  public void testContactFields() {
    app().goTo().homePage();
    ContactData contact = app().contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app().contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    String a = contact.getAddress();
    String b = contactInfoFromEditForm.getAddress();
    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
  }

  private String mergeEmails(ContactData contact) {
    String returnStatement = Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
    return returnStatement;
  }

  private String mergePhones(ContactData contact) {
    String returnStatement = Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactFieldTests::cleaned)
            .collect(Collectors.joining("\n"));
    return returnStatement;
  }



  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
