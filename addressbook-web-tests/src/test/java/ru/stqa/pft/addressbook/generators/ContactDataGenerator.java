package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<ContactData> contacts = generateContacts(count);
    save(contacts, file);
  }

  private static void save(List<ContactData> contacts, File file) throws IOException {
    Writer writter = new FileWriter(file);
    for (ContactData contact : contacts) {
      writter.write(String.format("%s;%s;%s;%s\n", contact.getFirstname(), contact.getMiddlename(),
              contact.getLastname(), contact.getMobilePhone()));
    }
    writter.close();
  }

  private static List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withFirstname(String.format("Firstname %s", i)).withLastname(String.format("Lastname %s", i))
              .withMiddlename(String.format("Middlename %s", i)).withMobilePhone(String.format("7999111221 %s", i)));
    }
    return contacts;
  }
}
