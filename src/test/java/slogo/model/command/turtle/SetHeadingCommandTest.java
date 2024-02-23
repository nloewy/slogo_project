package slogo.model.command.turtle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.CommandNode;
import slogo.model.ConstantNode;
import slogo.model.Node;
import slogo.model.Turtle;

public class SetHeadingCommandTest {

  public static final double DELTA = 0.001;

  private Turtle myTurtle;
  private Node node;

  @BeforeEach
  void setUp()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

    myTurtle = new Turtle(1);
    node = new CommandNode("slogo.model.command.turtle.SetHeadingCommand", myTurtle);

  }

  @Test
  void testBasicHeading()
      throws InvocationTargetException, IllegalAccessException {
    String newHeading = "75";
    node.addChildren(new ConstantNode(newHeading, myTurtle));
    assertEquals(75, node.getValue(), DELTA);
    assertEquals(75, myTurtle.getHeading(), DELTA);

  }

  @Test
  void testHeadingWithNonZeroInitial()
      throws InvocationTargetException, IllegalAccessException {
    myTurtle.setHeading(60);
    String newHeading = "20";
    node.addChildren(new ConstantNode(newHeading, myTurtle));
    assertEquals(40, node.getValue(), DELTA);
    assertEquals(20, myTurtle.getHeading(), DELTA);
  }

  @Test
  void testHeadingOver360()
      throws InvocationTargetException, IllegalAccessException {
    String newHeading = "940";
    myTurtle.setHeading(500);
    node.addChildren(new ConstantNode(newHeading, myTurtle));
    assertEquals(80, node.getValue(), DELTA);
    assertEquals(220, myTurtle.getHeading(), DELTA);
  }

  @Test
  void testHeadingNoChange()
      throws InvocationTargetException, IllegalAccessException {
    String newHeading = "1081";
    myTurtle.setHeading(361);
    node.addChildren(new ConstantNode(newHeading, myTurtle));
    assertEquals(0, node.getValue(), DELTA);
    assertEquals(1, myTurtle.getHeading(), DELTA);
  }

  @Test
  void testHeadingNegativeValue()
      throws InvocationTargetException, IllegalAccessException {
    String newHeading = "-270";
    myTurtle.setHeading(95);
    node.addChildren(new ConstantNode(newHeading, myTurtle));
    assertEquals(5, node.getValue(), DELTA);
    assertEquals(90, myTurtle.getHeading(), DELTA);
  }
}