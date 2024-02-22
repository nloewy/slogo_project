package slogo.model.command.turtle;

import java.util.List;
import slogo.model.SlogoListener;
import slogo.model.Turtle;
import slogo.model.command.Command;

public class PenUpCommand extends Command {

  private Turtle myTurtle;

  public PenUpCommand(Turtle turtle) {
    myTurtle = turtle;
  }

  @Override
  public double execute(List<Double> arguments) {
    myTurtle.setPen(false);
    return 0.0;
  }
  public void notifyListener(SlogoListener listener, double value) {
    listener.onUpdateTurtleState(myTurtle.getImmutableTurtle(), value);
  }


}
