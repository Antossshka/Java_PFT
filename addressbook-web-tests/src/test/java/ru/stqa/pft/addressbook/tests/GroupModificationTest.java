package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase{

  @Test
  public void testGroupModification() {
    app.navigationHelper().gotoGroupPage();
    app.groupHelper().selectGroup();
    app.groupHelper().initGroupModification();
    app.groupHelper().fillGroupForm(new GroupData("test1", "test23", "test34"));
    app.groupHelper().submitGroupModification();
    app.groupHelper().returnToGroupPage();
  }
}
