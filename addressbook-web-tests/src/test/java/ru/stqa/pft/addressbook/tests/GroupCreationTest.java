package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;
import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.navigationHelper().gotoGroupPage();
    List<GroupData> before = app.groupHelper().getGroupList();
    app.groupHelper().createGroup(new GroupData("test1", null, null));
    List<GroupData> after = app.groupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);
    app.logout();
  }

}
