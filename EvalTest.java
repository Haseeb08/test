package InfixEval;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EvalTest {

	@SuppressWarnings("deprecation")
	@Test
	void test() {
	
		Eval e = new Eval();
		
		 //Error : Divide by 0 and empty Expression
		assertEquals("Invalid Expression",e.evaluate("2*2-3/0*1")); 
		assertEquals("Invalid Expression",e.evaluate(""));
		
		
		//Error : Misplacing of brackets
		assertEquals("Invalid Expression",e.evaluate("1*(5-2/1"));      		// Error : Missing Close bracket.
		assertEquals("Invalid Expression",e.evaluate("1*5-2)/1"));       		 //Error : Missing Open bracket.	
		assertEquals("Invalid Expression",e.evaluate("1*2+(3*4-5+(4/2+1)"));   //Error : Missing Equal number of open-close brackets.
		assertEquals("Invalid Expression",e.evaluate("1*2+(3*4-5+(4/2)+1"));
		assertEquals("Invalid Expression",e.evaluate("1*2+(3*4(-5+(4/2)+1"));
		assertEquals("Invalid Expression",e.evaluate("1*2+(3*4+(30/5-5+(4/2)+1)"));  //Error : Missing Equal number of open-close brackets.
		assertEquals("18.0",e.evaluate("1*2+(3*4+(30/5)-5+(4/2)+1)"));
		assertEquals("1.0",e.evaluate("2*2-3*1"));	

		
		//Error : Incorrect order of operators
		assertEquals("Invalid Expression",e.evaluate("1++2"));    
		assertEquals("Invalid Expression",e.evaluate("1+-2"));    
		assertEquals("Invalid Expression",e.evaluate("2*+0.6"));     		
		assertEquals("Invalid Expression",e.evaluate("3*2(5-2)+1"));  
		assertEquals("Invalid Expression",e.evaluate("1*2+(5-2)1"));  
		
		//Error : Checking decimal operands
		assertEquals("5.6",e.evaluate("2*2.5+0.6"));
		assertEquals("5.6",e.evaluate("2*2.5+0.6"));
		assertEquals("1.6",e.evaluate("2*.5+0.6"));  
		assertEquals("Invalid Expression",e.evaluate("2*2.5.8+0.6"));
		
		//Error : Invalid operand
		assertEquals("Invalid Expression",e.evaluate("2*1a+0.6"));
		assertEquals("Invalid Expression",e.evaluate("2*1/$+0.6"));
		assertEquals("Invalid Expression",e.evaluate("5/2* +0.6"));
		
		
		
		
		
	}

}
