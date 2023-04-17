package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase{

  @Test
  public void testGroupDeletion() throws Exception {
    app.navigationHelper().gotoGroupPage();
    app.groupHelper().selectGroup();
    app.groupHelper().deleteSelectedGroups();
    app.groupHelper().returnToGroupPage();
  }

}
