package slogo.model.command.query;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import slogo.model.ModelState;
import slogo.model.Turtle;
import slogo.model.api.SlogoListener;
import slogo.model.command.Command;
import slogo.model.node.Node;

/**
 * The IsShowingCommand class represents a command that checks whether the requested turtle is
 * showing. It returns 1 if the requested turtle is showing, and 0 otherwise.
 *
 * @author Noah Loewy
 */
public class IsShowingCommand implements Command {

  /**
   * The number of arguments this command requires.
   */
  public static final int NUM_ARGS = 0;

  private final ModelState modelState;

  /**
   * Constructs an instance of IsShowingCommand with the given model state and listener.
   *
   * @param modelState the model state
   * @param listener   the listener for state change events
   */
  public IsShowingCommand(ModelState modelState, SlogoListener listener) {
    this.modelState = modelState;
  }

  /**
   * Checks whether the requested turtle is showing.
   *
   * @param arguments a list of nodes representing arguments (not used in this command)
   * @return 1 if the requested turtle is showing, 0 otherwise
   * @throws InvocationTargetException if an error occurs during execution
   * @throws IllegalAccessException    if access is denied during execution
   */
  @Override
  public double execute(List<Node> arguments)
      throws InvocationTargetException, IllegalAccessException {
    Turtle turtle = modelState.getTurtles().get(1);
    if (turtle.getVisible()) {
      return 1.0;
    }
    return 0.0;
  }
}
