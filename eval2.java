
package InfixEval;
import java.util.Stack;

public class eval2 {
	
	
	
    public String evaluate(String expression){
    
    	try {
    	Stack<Double> numbers = new Stack<>();
       
        Stack<Character> operations = new Stack<>();
        for(int i=0; i<expression.length();i++) {
           
        	char c = expression.charAt(i);
        	
        	
            if(Character.isDigit(c) ||c=='.'){
            	String num="";
		           if(i<expression.length())
		            	{
		        	
		            	//char nextChar = expression.charAt(i+1);
		            		while(Character.isDigit(c) || c=='.') {
		            			num=num+c;
		            			 if(i<expression.length()-1)
		            			c = expression.charAt(++i);
		            			 else break;
		            			}
		            	}
		         
		           numbers.push(Double.parseDouble(num));
		          
		    }
            
             if(c=='('){
                operations.push(c);
            }
            else if(c==')') {
                while(operations.peek()!='('){
                    double output = performOperation(numbers, operations);
                      numbers.push(output);
                }
                operations.pop();
            }
            else if(isOperator(c)){
          	
                while(!operations.isEmpty() && precedence(c)<=precedence(operations.peek())){
                    double output = performOperation(numbers, operations);
                    numbers.push(output);
                }
              operations.push(c);
            }
            else if(Character.isLetter(c))
          	  return "Invalid Expression";
        }
      
        while(!operations.isEmpty()){
            double output = performOperation(numbers, operations);
             numbers.push(output);
        }
        
      double res= numbers.pop();  
      if(numbers.isEmpty())
        return ""+res;
      else
    	  return "Invalid Expression";
    
	}
	catch(Exception e) {
		return "Invalid Expression";
	}
	}
	
    private int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    private double performOperation(Stack<Double> numbers, Stack<Character> operations) {
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

    private boolean isOperator(char c){
        return (c=='+'||c=='-'||c=='/'||c=='*');
    }

   public static void main(String[] args) {
        String Expression = "3*(0-2)";
        eval2 i = new eval2();
        System.out.println(i.evaluate(Expression));
    }
   
}