/* 
 * Program description:
 * The program requests a math expression from the user. The user
 * enters the math expression which is stored in a string variable
 * and passed to the expressionEvalation method. expressionEvaluation
 * iterates over the string variable and evaluates each char
 * against conditional if-statements which if met, will assign a boolean
 * "error" to true or false. If true, an error message is printed and the 
 * while loop main re-starts. If there is no error, mathExpression is passed 
 * to InfixtoPostfix and converts it to postfix. The postfix is then passed to
 * postfixEvaluation which computes the value of the expression.
 * 
 * entering 0 for mathExpression will terminate the program.
 * 
 */
package main.java;

import java.util.*;


public class MyExpressionTest {

	// variable and data structure creation
	static String mathExpression;
	static Scanner input = new Scanner(System.in);
	static HashMap<Integer, String> errorMessage = new HashMap<>();
	
	
	
	public static void main(String[] args) 
	{
		// load error messages key-value pairs into hash map
		LoadErrorMessage();
		
		boolean error = false;
		
		// loop indefinitely
		while (true)
		{
			// user prompt
			System.out.println("\nEnter a math expression or 0 to exit: ");
			mathExpression = input.nextLine();
			
			// exit command
			if(mathExpression.equals("0"))
			{
				System.out.println("Thanks for stopping by, come back soon!");
				break; 
				
			}
			else
			
			{
				// create an ExpressionEvaluation object named 'ee'.
				ExpressionEvaluation ee = new ExpressionEvaluation();
				
				// check user input for errors  
				error = ee.expressionEvaluation(mathExpression);
				

			}
			// if no error found perform postfix conversion and evaluation
			if(!error)
			{
				
				// create an InfixToPostfix object named "i2p"
				InfixToPostfix i2p = new InfixToPostfix();
				
				// create the postfix string with the user input
				String postfix = i2p.infix2postfix(mathExpression);
				
				// create a PostfixEvaluation object name "pe"
				PostfixEvaluation pe = new PostfixEvaluation();
				
				// calculate the expression result from the postfix string
				int result = pe.postfixEvaluation(postfix);
				
				// prints results
				System.out.println("infix: " + mathExpression);
				System.out.println("postfix: " + printable_postfix(postfix));
				System.out.println("result: " + result);
			}
			
		}

	}
	/**
	 * load error messages key-value pairs into hash map
	 *
	 * @param N/A
	 * @return N/A
	 */
	public static void LoadErrorMessage()
	{
		errorMessage.put(1, "} expected");
		errorMessage.put(2, ") expected");
		errorMessage.put(3, "Incomplete Expression");
	}
	
	/**
	 * Removes spaces from the postfix string for printing.
	 *
	 * @param input = postfix string with spaces.
	 * @return a postfix string without spaces.
	 */
	public static String printable_postfix(String input) {
		
		// initialize a string
		String output = "";
		
		// iterate through the string
		for(int i=0; i<input.length(); i++){
			
			// if not blank, concatenate chars
			if(input.charAt(i) !=' ') {
				
				output += input.charAt(i);
			}
		}
		
		return output;
	}
	
}
