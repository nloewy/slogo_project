package slogo.model.node;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import slogo.model.api.IncompleteClassException;

public abstract class Node {

  private final List<Node> myChildren = new ArrayList<>();

  public abstract double getValue() throws InvocationTargetException, IllegalAccessException;

  public List<Node> getChildren() {
    return myChildren;
  }

  public void addChild(Node node) {
    myChildren.add(node);
  }

  public abstract String getToken();

  public int getNumArgs()
      throws IncompleteClassException {
    return 0;
  }
}


