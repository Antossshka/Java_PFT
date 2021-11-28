package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTest {

  @Test
  public void TestDistance() {
    Point p1 = new Point(8,2);
    Point p2 = new Point(3, 9);
    Assert.assertEquals(p1.distance(p2), 8.602325267042627);
  }

  @Test
  public void TestDistance2() {
    Point p1 = new Point(-5,-4);
    Point p2 = new Point(-2, -8);
    Assert.assertEquals(p1.distance(p2), 5);
  }

  @Test
  public void TestDistance3(){
    Point p1 = new Point(8,6);
    Point p2 = new Point(-9, -1);
    Assert.assertEquals(Task2.distance(p1, p2), 18.384776310850235);
  }

  @Test
  public void TestDistance4(){
    Point p1 = new Point(-5,-8);
    Point p2 = new Point(11, 6);
    Assert.assertEquals(Task2.distance(p1, p2), 21.2602916254693);
  }
}
