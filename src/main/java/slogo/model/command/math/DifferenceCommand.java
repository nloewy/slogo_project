package slogo.model.command.math;

import java.util.List;
import slogo.model.ModelState;
import slogo.model.api.SlogoListener;
import slogo.model.command.Command;
import slogo.model.node.Node;

/**
 * The DifferenceCommand class represents the subtraction mathematical operation. It calculates the
 * difference between two numbers.
 *
 * @author Noah Loewy
 */
public class DifferenceCommand implements Command {

  /**
   * The number of arguments this command requires.
   */
  public static final int NUM_ARGS = 2;
  private final ModelState modelState;

  /**
   * Constructs an instance of DifferenceCommand with the given model state and listener. This
   * constructor does not actually do anything, and exists for the sake of consistency across
   * commands.
   *
   * @param modelState the model state
   * @param listener   the listener for state change events
   */
  public DifferenceCommand(ModelState modelState, SlogoListener listener) {
    this.modelState = modelState;
  }

  /**
   * Executes the subtraction mathematical operation.
   *
   * @param arguments a list containing two nodes representing the numbers to subtract
   * @param turtleId  the id of the turtle currently active
   * @return the difference between the two input numbers
   */
  @Override
  public double execute(List<Node> arguments, int turtleId) {
    modelState.setOuter(false);
    double arg1 = arguments.get(0).evaluate();
    double arg2 = arguments.get(1).evaluate();
    return arg1 - arg2;
  }
}
