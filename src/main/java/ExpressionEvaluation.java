package main.java;

import java.util.*;

/**
 * This class represents the error checking and reporting functionality
 * of supplied infix expressions from the user.
 */
public class ExpressionEvaluation 
{
	// create hash maps for error messages and bracket pairs
	static HashMap<Integer, String> errorMessage = new HashMap<>();
	static HashMap<Character, Character> pair = new HashMap<>();
	
	/**
	 * This method examines the statement supplied by the user for the correct
	 * type and number of brackets. If brackets are missing or of the wrong type,
	 * error messages will be displayed.
	 * 
	 * @param statement - Arithmetic expression entered by the user
	 * @return error - indicates if an error in the expression was found
	 */
	public boolean expressionEvaluation(String statement)
	{
		// load hash map pair
		loadPair();
		
		// load hash map error messages
		LoadErrorMessage();
		
		
		// create stack to hold left-handed brackets
		Stack<Character> stack = new Stack<>();
		
		
		// iterate over entire statement
		for(int j = 0; j<statement.length(); j++)
		{
			char c = statement.charAt(j);
			
			// push left-handed parenthesis and brackets to stack
			if(c == '(' || c == '{') 
			{
				stack.push(c);
			}
			
			// check for matching parenthesis
			if(c == ')')
			{
				// empty stack = no matching pair, hence error
				if(stack.isEmpty())
				{
					printError(0, 3);
					return true;
				}
				// search stack for matching pair and print error if not found
				else
				{
					char PoppedChar = stack.pop();
					if(!(PoppedChar == pair.get(c)))
					{
						printError(j, 1);
						return true;
					}
				}
			}
			// check for matching bracket
			if(c == '}')
			{	
				// empty stack = no matching pair, hence error
				if(stack.isEmpty())
				{
					printError(0, 3);
					return true;
				}
				
				// search stack for matching pair and print error if not found
				else
				{
					char PoppedChar = stack.pop();
					if(!(PoppedChar == pair.get(c)))
					{
						printError(j, 2);
						return true;
					}
				}
			}		
		}
		
		/*
		 * check for unmatched bracket/parenthesis and if stack is not empty.
		 */
		if(statement.charAt(statement.length()-1) == '{' 
				|| statement.charAt(statement.length()-1) == '(' || !stack.isEmpty())
		{
			printError(statement.length()-1, 3);
			return true;
		}
		
		// return false if no errors are found
		return false;  
	}
	
	/**
	 * Prints an error message underneath the expression with a carrot indicating the error position.
	 * 
	 * @param location - string index where error was found in the string.
	 * @param errorNo - desired error number to display from hash map.
	 * @return N/A
	 */
	public static void printError(int location, int errorNo)
	{
		for(int i = 0; i<location; i++)
		{
			System.out.print(" ");
		}
		System.out.print("^ ");
		System.out.println(errorMessage.get(errorNo));
		
	}
	/**
	 * Loads hash map with bracket pairs. Hash map is used to confirm matching bracket pair 
	 * for error checking
	 * 
	 * @params N/A 
	 * @retun N/A
	 */
	public static void loadPair()
	{
		pair.put('}', '{');
		pair.put(')', '(');
	}
	
	/**
	 * Loads hash map error messages. Hash map is used to display error messages depending on the error.
	 * 
	 * @params N/A 
	 * @retun N/A
	 */
	public static void LoadErrorMessage()
	{
		errorMessage.put(1, "} expected");
		errorMessage.put(2, ") expected");
		errorMessage.put(3, "Incomplete Expression");
	}

}
