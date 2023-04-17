package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.navigationHelper().gotoGroupPage();
    app.groupHelper().initGroupCreation();
    app.groupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.groupHelper().submitGroupCreation();
    app.groupHelper().returnToGroupPage();
    app.logout();
  }

}
