package slogo.model.command.control;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import slogo.model.ModelState;
import slogo.model.Turtle;
import slogo.model.command.CommandTest;
import slogo.model.node.CommandNode;
import slogo.model.node.ConstantNode;
import slogo.model.node.ListNode;
import slogo.model.node.Node;

public class IfCommandTest extends CommandTest {


  public static final double DELTA = 0.001;

  private Turtle myTurtle;
  private Node node;
  private ModelState model;


  @Test
  public void testIfCommandTrue()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    model = new ModelState();
    myTurtle = new Turtle(1);
    model.getTurtles().put(1, myTurtle);
    model.getActiveTurtles().add(new ArrayList<>());
    model.getActiveTurtles().peek().add(1);

    node = new CommandNode("If", model);
    Node nodeTwo = new CommandNode("Sum", model);
    Node nodeThree = new ConstantNode("-5", model);
    Node nodeFour = new ConstantNode("7", model);
    node.addChild(nodeTwo);
    nodeTwo.addChild(nodeThree);
    nodeTwo.addChild(nodeFour);
    Node nodeFive = new ListNode("", model);
    node.addChild(nodeFive);
    Node nodeSix = new CommandNode("Backward", model);
    nodeSix.addChild(new ConstantNode("60", model));
    nodeFive.addChild(nodeSix);
    Node nodeSeven = new CommandNode("Backward", model);
    nodeSeven.addChild(new ConstantNode("30", model));
    nodeFive.addChild(nodeSeven);
    dfsAddListener(node);
    Assertions.assertEquals(30.0, node.evaluate(), DELTA);
    Assertions.assertEquals(90.0, myTurtle.getY(), DELTA);
  }

  @Test
  public void testIfCommandFalse()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    model = new ModelState();
    myTurtle = new Turtle(1);
    model.getTurtles().put(1, myTurtle);
    model.getActiveTurtles().add(new ArrayList<>());
    model.getActiveTurtles().peek().add(1);
    node = new CommandNode("If", model);
    Node nodeTwo = new CommandNode("Sum", model);
    Node nodeThree = new ConstantNode("-5", model);
    Node nodeFour = new ConstantNode("5", model);
    node.addChild(nodeTwo);
    nodeTwo.addChild(nodeThree);
    nodeTwo.addChild(nodeFour);
    Node nodeFive = new ListNode("", model);
    node.addChild(nodeFive);
    Node nodeSix = new CommandNode("Backward", model);
    nodeSix.addChild(new ConstantNode("60", model));
    nodeFive.addChild(nodeSix);
    Node nodeSeven = new CommandNode("Backward", model);
    nodeSeven.addChild(new ConstantNode("30", model));
    dfsAddListener(node);
    Assertions.assertEquals(0.0, node.evaluate(), DELTA);
    Assertions.assertEquals(0.0, myTurtle.getY(), DELTA);
  }

}
