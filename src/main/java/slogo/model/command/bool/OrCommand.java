package slogo.model.command.bool;

import java.util.List;
import slogo.model.ModelState;
import slogo.model.api.SlogoListener;
import slogo.model.command.Command;
import slogo.model.node.Node;

/**
 * The OrCommand class represents the logical OR operation. It evaluates two nodes and returns 1.0
 * if at least one of the nodes' values is non-zero, otherwise returns 0.0.
 *
 * @author Noah Loewy
 */
public class OrCommand implements Command {

  /**
   * The number of arguments this command requires.
   */
  public static final int NUM_ARGS = 2;
  private static final double TOLERANCE = .001;

  private final ModelState modelState;

  /**
   * Constructs an instance of OrCommand with the given model state and listener.
   *
   * @param modelState the model state
   * @param listener   the listener for state change events
   */
  public OrCommand(ModelState modelState, SlogoListener listener) {
    this.modelState = modelState;

  }

  /**
   * Executes the logical OR operation on the provided nodes.
   *
   * @param arguments a list of nodes representing values to be compared
   * @param turtleId  the id of the turtle currently active
   * @return 1.0 if at least one of the nodes' values is non-zero, otherwise returns 0.0
   */
  @Override
  public double execute(List<Node> arguments, int turtleId) {
    modelState.setOuter(false);
    return (!(Math.abs(arguments.get(0).evaluate()) <= TOLERANCE) ||
        !(Math.abs(arguments.get(1).evaluate()) <= TOLERANCE)) ? 1.0 : 0.0;
  }
}
