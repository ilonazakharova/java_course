package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testsDistance1 () {
    Point p1 = new Point(4.0, 6.0);
    Point p2 = new Point(6.0, 7.0);
    assert p1.distance(p2) == 2.23606797749979;
  }

  @Test
  public void testsDistance2 () {
    Point p1 = new Point(4.0, 6.0);
    Point p2 = new Point(6.0, 7.0);
    Assert.assertEquals(p1.distance(p2), 2.23606797749979);
  }



}
