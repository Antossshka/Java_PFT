package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase{

  @Test
  public void testGroupDeletion() throws Exception {
    app.navigationHelper().gotoGroupPage();
    if (! app.groupHelper().isThereAGroup()) {
      app.groupHelper().createGroup(new GroupData("test1", null, null));
    }
    int before = app.groupHelper().getGroupCount();
    app.groupHelper().selectGroup();
    app.groupHelper().deleteSelectedGroups();
    app.groupHelper().returnToGroupPage();
    int after = app.groupHelper().getGroupCount();
    Assert.assertEquals(after, before - 1);
  }

}
