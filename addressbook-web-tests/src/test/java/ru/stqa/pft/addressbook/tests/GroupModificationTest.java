package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase{

  @Test
  public void testGroupModification() {
    app.navigationHelper().gotoGroupPage();
    if (! app.groupHelper().isThereAGroup()) {
      app.groupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.groupHelper().selectGroup();
    app.groupHelper().initGroupModification();
    app.groupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.groupHelper().submitGroupModification();
    app.groupHelper().returnToGroupPage();
  }
}
