package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.*;

public class GroupModificationTest extends TestBase{

  @Test
  public void testGroupModification() {
    app.navigationHelper().gotoGroupPage();
    if (! app.groupHelper().isThereAGroup()) {
      app.groupHelper().createGroup(new GroupData("test1", null, null));
    }
    List<GroupData> before = app.groupHelper().getGroupList();
    app.groupHelper().selectGroup(before.size() - 1);
    app.groupHelper().initGroupModification();
    GroupData group = new GroupData("test1", "test2", "test3", before.get(before.size() - 1).getId());
    app.groupHelper().fillGroupForm(group);
    app.groupHelper().submitGroupModification();
    app.groupHelper().returnToGroupPage();
    List<GroupData> after = app.groupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
