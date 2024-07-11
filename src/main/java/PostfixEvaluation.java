package main.java;

import java.util.*;

/**
 * This class represents the final evaluation of the user input by converting
 * the postfix string to an integer result.
 */
public class PostfixEvaluation
{
	/**
	 * This method evaluates a postfix string and returns a numerical result.
	 * The for loop iterates through each char of the postfix string converting 
	 * valid chars to integers and leveraging a stack to perform cumulative
	 * calculations.
	 * 
	 * @param postfix - postfix string created from InfixToPostfix class
	 * @return result - integer value that represents 
	 */
	public int postfixEvaluation(String postfix)
	{
		//create a new stack
		Stack <Integer> stack = new Stack<>();
		
		// initialize a digit string
		String digitString = "";
		
		// initialize running digit value
		int value = 0;
		
		// iterate over the postfix string
		for(int k = 0; k< postfix.length(); k++)
		{
			char c = postfix.charAt(k);
			
			// if char is a digit, concatenate to digitString
			if(Character.isDigit(c))
			{
				digitString += c;
			}
			// convert digitString to integer if current char is blank
			else if (!digitString.isEmpty() && !Character.isDigit(c)) {
				
				// convert to a digit
				value = Integer.parseInt(digitString);
				
				stack.push(value);
				
				// reset the digitString
				digitString = "";
				
				// reset the value
				value = 0;
				
			}
			// handle operators
			else if (c == '+' || c == '-' || c == '*' || c == '/')
			{
				// handle if no blanks were used
				if(!digitString.isEmpty()) {
					// reset the digitString
					digitString = "";
					
					// reset the value
					value = 0;
				}
				// stack is popped twice and each is assigned to value1 and value2
				int value1 = stack.pop();
				int value2 = stack.pop();
				
				// initiate newValue
				int newValue = 0;
				
				// switch block to calculate values based on operators
				switch(c) {
					case '+':
						newValue = value2 + value1;
						break;
					case '-':
						newValue = value2 - value1;
						break;
					case '*':
						newValue = value2 * value1;
						break;
					case '/':
						newValue = value2 / value1;
						break;
				}
				// push newValue to the stack
				stack.push(newValue);	
			}
		}
		
		// last value in the stack is the final result 
		int result = stack.pop();
		
		return result;
	}
	
}
