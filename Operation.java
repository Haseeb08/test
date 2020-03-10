package InfixEval;

import java.util.Stack;

public class Operation {

    public double performOperation(Stack<Double> numbers, Stack<Character> operations) {
        double a = numbers.pop();
        double b = numbers.pop();
        char operation = operations.pop();
      
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                if (a == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return b / a;
        }
        return 0;
    }
    public int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }
    public boolean isOperator(char c){
        return (c=='+'||c=='-'||c=='/'||c=='*');
    }
}
