package InfixEval;

import java.util.Stack;

public class ExpressionEvaluate {
	public String evaluate(String expression){
	    Operation op=new Operation();
    	try {
    	Stack<Double> numbers = new Stack<>();    
        Stack<Character> operations = new Stack<>();
        for(int i=0; i<expression.length();i++) {
           
        	char c = expression.charAt(i);
        		
            if(Character.isDigit(c) ||c=='.'){
            	String num="";
            	
		           if(i<expression.length())
		            	{
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
                    double output = op.performOperation(numbers, operations);
                      numbers.push(output);
                }
                operations.pop();
            }
            else if(op.isOperator(c)){
          	
            	
            	
                while(!operations.isEmpty() && op.precedence(c)<=op.precedence(operations.peek())){
                    double output = op.performOperation(numbers, operations);
                    numbers.push(output);
                }
              operations.push(c);
            }
            else if(Character.isLetter(c))
          	  return "Invalid Expression";
        }
      
        while(!operations.isEmpty()){
            double output = op.performOperation(numbers, operations);
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
}
