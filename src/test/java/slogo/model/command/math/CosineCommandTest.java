package slogo.model.command.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import slogo.model.CommandNode;
import slogo.model.ConstantNode;
import slogo.model.ModelState;
import slogo.model.Node;
import slogo.model.Turtle;

public class CosineCommandTest {

  public static final double DELTA = 0.001;

  private Turtle myTurtle;
  private Node node;

  @BeforeEach
  void setUp()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    myTurtle = null;
    ModelState model = new ModelState();
    node = new CommandNode("slogo.model.command.math.CosineCommand", model);
  }

  @ParameterizedTest
  @CsvSource({
      "0, 1.0",
      "30, 0.86602540378",
      "45, 0.70710678118",
      "60, 0.5",
      "90, 0.0",
      "180, -1.0",
      "270, 0.0",
      "360, 1.0",
      "720, 1.0",
      "-30, 0.86602540378",
      "-45, 0.70710678118",
      "-60, 0.5",
      "-90, 0.0",
      "-180, -1.0",
      "-270, 0.0",
      "-360, 1.0",
      "88.5, 0.0261769483"
  })
  void testCosineBasic(String op1, String result)
      throws InvocationTargetException, IllegalAccessException {
    node.addChildren(new ConstantNode(op1, myTurtle));
    assertEquals(Double.parseDouble(result), node.getValue(), DELTA);
  }
}
