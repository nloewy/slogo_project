package slogo.model.command.turtle;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import slogo.model.ModelState;
import slogo.model.SlogoListener;
import slogo.model.Turtle;
import slogo.model.command.Command;
import slogo.model.node.Node;

public class BackwardCommand extends Command {

  private final ModelState modelState;
  private final SlogoListener listener;

  public BackwardCommand(ModelState modelState, SlogoListener listener) {
    this.modelState = modelState;
    this.listener = listener;
  }

  public double execute(List<Node> arguments)
      throws InvocationTargetException, IllegalAccessException {
    double pixels = arguments.get(0).getValue();
    return modelState -> {
      Turtle turtle = modelState.getTurtles().get(0);
      double newX = turtle.getX() - pixels * Math.sin(Math.toRadians(turtle.getHeading()));
      double newY = turtle.getY() - pixels * Math.cos(Math.toRadians(turtle.getHeading()));
      turtle.setX(newX);
      turtle.setY(newY);
      return pixels;
    };
  }

  @Override
  public int getNumArgs() {
    return 1;
  }

  /**@Override public void notifyListener(SlogoListener listener, double value) {
  super.notifyListener(listener, value);
  listener.onUpdateTurtleState(myTurtle.getImmutableTurtle());
  }
   */

}
