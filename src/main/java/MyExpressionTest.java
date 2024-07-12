package main.java;

import java.util.Scanner;

/**
 * This class contains the main entry point of the program.
 * The user is prompted for input which is then evaluated for
 * error. If no expression errors are found, the infix
 * expression is converted to postfix and evaluated.
 */
public class MyExpressionTest {

	/**
	 * Variable for user input.
	 */
	static String mathExpression;
	/**
	 * scanner object to collect keyboard input.
	 */
	static Scanner input = new Scanner(System.in);


	public static void main(String[] args) {
		boolean error = false;

		// instantiate classes
		ExpressionEvaluation ee = new ExpressionEvaluation();
		InfixToPostfix i2p = new InfixToPostfix();
		PostfixEvaluation pe = new PostfixEvaluation();

		// loop indefinitely
		while (true) {

			// user prompt
			System.out.println("\nEnter a math "
					+ "expression or 0 to exit: ");

			// user input
			mathExpression = input.nextLine();

			// exit command
			if (mathExpression.equals("0")) {

				System.out.println("Thanks for stopping by, "
						+ "come back soon!");
				break;

			} else {

				// check user input for errors
				error = ee.expressionEvaluation(mathExpression);
			}
			// if no error, convert and evaluate
			 if (!error) {

				// create the postfix string with the user input
				String postfix = i2p.infix2postfix(mathExpression);

				// evaluate the result
				int result = pe.postfixEvaluation(postfix);

				// prints results
				System.out.println("infix: " + mathExpression);

				System.out.println("postfix: "
				+ printable_postfix(postfix));

				System.out.println("result: " + result);
			}
		}
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
		for (int i = 0; i < input.length(); i++) {

			// if not blank, concatenate chars
			if (input.charAt(i) != ' ') {

				output += input.charAt(i);
			}
		}

		return output;
	}
}
