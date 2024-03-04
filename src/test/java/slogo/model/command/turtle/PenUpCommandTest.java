package slogo.model.command.turtle;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.ModelState;
import slogo.model.Turtle;
import slogo.model.command.CommandTest;
import slogo.model.node.CommandNode;
import slogo.model.node.Node;

public class PenUpCommandTest extends CommandTest {

  public static final double DELTA = 0.001;

  private Turtle myTurtle;
  private Node node;

  @BeforeEach
  void setUp()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    ModelState model = new ModelState();
    model.getTurtles().put(1, new Turtle(1));
    myTurtle = model.getTurtles().get(1);
    node = new CommandNode("turtle.PenUp", model);
    node.addListener(myListener);
  }

  @Test
  void testBasicUp()
      throws InvocationTargetException, IllegalAccessException {
    myTurtle.setPen(false);
    Assertions.assertEquals(0, node.evaluate());
    Assertions.assertFalse(myTurtle.getPen());
  }

  @Test
  void testPenUpAlreadyUp()
      throws InvocationTargetException, IllegalAccessException {
    myTurtle.setPen(false);
    Assertions.assertEquals(0, node.evaluate());
    Assertions.assertFalse(myTurtle.getPen());
  }
}

