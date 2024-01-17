package org.example.chapter8.recursion_and_dynamic_programming;

import static java.lang.Integer.parseInt;

public class Task8_14 {

  public static void main(String[] args) {
    var expression = "1^0|0|1";
    var waysCount = calculateWays(expression, true);
    System.out.println("waysCount = " + waysCount);
  }

  private static int calculateWays(String expression, boolean expected) {
    return calculateWays(expression, expression.length() / 2, expected ? 1 : 0);
  }

  private static int calculateWays(String expression, int operatorsCount, int expected) {
    if(expression.length() == 1 && parseInt(expression) == expected) {
      return 1;
    }

    var ways = 0;
    for(int j = 1; j <= operatorsCount; j++) {
      ways += calculateWays(simplifyExpression(expression, j), operatorsCount - 1, expected);
    }
    return ways;
  }

  private static String simplifyExpression(String expression, int operatorIndex) {
    var leftOperandIndex = (operatorIndex - 1) * 2;
    var leftOperand = parseInt(expression.substring(leftOperandIndex, leftOperandIndex + 1));

    var rightOperandIndex = operatorIndex * 2;
    var rightOperand = parseInt(expression.substring(rightOperandIndex, rightOperandIndex + 1));

    var operator = expression.charAt(operatorIndex * 2 - 1);
    var simplifiedResult = switch (operator) {
      case '&' -> leftOperand & rightOperand;
      case '|' -> leftOperand | rightOperand;
      case '^' -> leftOperand ^ rightOperand;
      default ->
        throw new IllegalArgumentException();
    };
    return expression.substring(0, leftOperandIndex) + simplifiedResult + expression.substring(rightOperandIndex + 1);
  }

}
