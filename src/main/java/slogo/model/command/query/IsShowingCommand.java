package slogo.model.command.query;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import slogo.model.ModelState;
import slogo.model.SlogoListener;
import slogo.model.Turtle;
import slogo.model.command.Command;
import slogo.model.node.Node;

public class IsShowingCommand extends Command {

  private final ModelState modelState;
  private final SlogoListener listener;

  public IsShowingCommand(ModelState modelState, SlogoListener listener) {
    this.modelState = modelState;
    this.listener = listener;
  }

  @Override
  public double execute(List<Node> arguments)
      throws InvocationTargetException, IllegalAccessException {
    return modelState -> {
      Turtle turtle = modelState.getTurtles().get(0);
      if (turtle.getVisible()) {
        return 1.0;
      }
      return 0.0;
    };
  }

  @Override
  public int getNumArgs() {
    return 0;
  }

  /**@Override public void notifyListener(SlogoListener listener, double value) {
  super.notifyListener(listener, value);
  listener.onUpdateTurtleState(myTurtle.getImmutableTurtle());
  }
   */
}
