package slogo.model.command.math;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import slogo.mathutils.MathUtils;
import slogo.model.ModelState;
import slogo.model.SlogoListener;
import slogo.model.command.Command;
import slogo.model.node.Node;

public class ArcTangentCommand extends Command {

  private final ModelState modelState;
  private final SlogoListener listener;

  public ArcTangentCommand(ModelState modelState, SlogoListener listener) {
    this.modelState = modelState;
    this.listener = listener;
  }

  @Override
  public double execute(List<Node> arguments)
      throws InvocationTargetException, IllegalAccessException {
    double arg1 = arguments.get(0).getValue();
    return modelState -> {
      return MathUtils.toDegrees(Math.atan(arg1));
    };
  }

  @Override
  public int getNumArgs() {
    return 1;
  }
  /**@Override public void notifyListener(SlogoListener listener, double value) {
  super.notifyListener(listener, value);
  }
   */

}
