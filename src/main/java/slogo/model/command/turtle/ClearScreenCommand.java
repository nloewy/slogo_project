package slogo.model.command.turtle;

import java.util.List;
import slogo.mathutils.MathUtils;
import slogo.model.SlogoListener;
import slogo.model.Turtle;
import slogo.model.api.TurtleRecord;
import slogo.model.command.Command;

public class ClearScreenCommand extends Command {

  private Turtle myTurtle;

  public ClearScreenCommand(Turtle turtle) {
    myTurtle = turtle;
  }

  @Override
  public double execute(List<Double> arguments) {
    double currentX = myTurtle.getX();
    double currentY = myTurtle.getY();
    myTurtle.setX(0);
    myTurtle.setY(0);
    return MathUtils.dist(0, 0, currentX, currentY);
  }

  public void notifyListener(SlogoListener listener, double value) {
    TurtleRecord turtleRecord = myTurtle.getImmutableTurtle();
    listener.onUpdateTurtleState(turtleRecord, value);
    listener.onResetTurtle(turtleRecord.id());
  }

}

