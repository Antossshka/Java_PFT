package ru.stqa.pft.sandbox;

public class Task2 {

  public static void main(String[] args) {

    Point p1 = new Point(3,6);
    Point p2 = new Point(2, 9);
    System.out.println("Расстояние между точками p1 и p2 = " + p1.distance(p2));
    System.out.println("Расстояние между точками p1 и p2 = " + distance(p1, p2));
  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
  }
}

class Point {

  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(Point p) {
    return Math.sqrt((this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y));
  }
}

