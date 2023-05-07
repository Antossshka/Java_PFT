package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import java.util.List;

public class GroupModificationTest extends TestBase{

  @Test
  public void testGroupModification() {
    app.navigationHelper().gotoGroupPage();
    if (! app.groupHelper().isThereAGroup()) {
      app.groupHelper().createGroup(new GroupData("test1", null, null));
    }
    List<GroupData> before = app.groupHelper().getGroupList();    app.groupHelper().selectGroup(before.size() - 1);
    app.groupHelper().initGroupModification();
    app.groupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.groupHelper().submitGroupModification();
    app.groupHelper().returnToGroupPage();
    List<GroupData> after = app.groupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());
  }
}
