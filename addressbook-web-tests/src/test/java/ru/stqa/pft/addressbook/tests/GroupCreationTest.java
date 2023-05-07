package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.navigationHelper().gotoGroupPage();
    List<GroupData> before = app.groupHelper().getGroupList();
    GroupData group = new GroupData("test1", "test2", "test3");
    app.groupHelper().createGroup(group);
    List<GroupData> after = app.groupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

    group.setID(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    app.logout();
  }

}
