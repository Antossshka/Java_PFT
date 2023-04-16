package ru.stqa.pft.addressbook;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class ContactCreationTest {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    wd.get("http://localhost/addressbook/group.php");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testContactCreation() throws Exception {
    initContactCreation();
    fillContactForm(new ContactData("Dmitry", "Blinovsky", "Petrov", "89991112299", "petrov.db@mail.ru", "Mowcow"));
    submitContactCreation();
    returnToHomePage();
  }

  private void returnToHomePage() {
    wd.findElement(By.linkText("home page")).click();
  }

  private void submitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void fillContactForm(ContactData contactData) {
    wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
    wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddlename());
    wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
    wd.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
    wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
    wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
  }

  private void initContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

}
