package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import java.util.List;

public class GroupDeletionTest extends TestBase{

  @Test
  public void testGroupDeletion() throws Exception {
    app.navigationHelper().gotoGroupPage();
    if (! app.groupHelper().isThereAGroup()) {
      app.groupHelper().createGroup(new GroupData("test1", null, null));
    }
    List<GroupData> before = app.groupHelper().getGroupList();
    app.groupHelper().selectGroup(before.size() - 1);
    app.groupHelper().deleteSelectedGroups();
    app.groupHelper().returnToGroupPage();
    List<GroupData> after = app.groupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);
  }

}
