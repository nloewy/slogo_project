package slogo.model.command.control;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import slogo.model.ModelState;
import slogo.model.api.SlogoListener;
import slogo.model.command.Command;
import slogo.model.node.Node;

public class ForCommand implements Command {

  public static final int NUM_ARGS = 2;
  private final ModelState modelState;

  public ForCommand(ModelState modelState, SlogoListener listener) {
    this.modelState = modelState;
  }

  @Override
  public double execute(List<Node> arguments)
      throws InvocationTargetException, IllegalAccessException {
    String variableName = arguments.get(0).getChildren().get(0).getToken();
    double start = arguments.get(0).getChildren().get(1).getValue();
    double end = arguments.get(0).getChildren().get(2).getValue();
    double increment = arguments.get(0).getChildren().get(3).getValue();
    Node commands = arguments.get(1);
    double res = 0.0;
    for (double i = start; i <= end; i += increment) {
      modelState.getVariables().put(variableName, i);
      res = commands.getValue();
      modelState.getVariables().remove(variableName);
    }
    return res;
  }
}
