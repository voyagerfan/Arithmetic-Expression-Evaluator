package main.java;

import java.util.HashMap;
import java.util.Stack;


/**
* This class represents the conversion from infix to postfix notation.
*/
public class InfixToPostfix {

	/**
	* This stack stores the precedence value of operators.
	*/
	static HashMap<Character, Integer> precedence = new HashMap<>();

	/**
	* This method receives the infix expression from the user
	* and iterates over each char.Operators and operands are
	* delineated by a space appended to the post variable in
	* order of operator precedence and brackets.
	*
	* @param infix - infix expression from the user
	* @return post - postfix expression.
	*/
	public String infix2postfix(String infix) {

		// create a stack
		Stack<Character> stack = new Stack<Character>();

		// load precedence key-value pairs into hash map
		loadPrecedence();

		// initialize the postfix string
		String post = "";

		// iterate through the infix string
		for (int j = 0; j < infix.length(); j++) {

			// access the current char
			char c = infix.charAt(j);

			// check if c is a digit
			if (Character.isDigit(c)) {

				post += c;

			}
			// check for space
			if (c == ' ') {

				try {

					// if previous char not space
					if (post.charAt(j - 1) != ' ') {

						post += " ";

					}
				} catch(StringIndexOutOfBoundsException e) {

				}

			// push bracket or parenthesis to the stack
			} else if (c == '(' || c == '{') {

				stack.push(c);

			// handle right-hand parenthesis
			} else if (c == ')') {

				char p = ' ';

				// check for left parenthesis
				if (stack.peek() != '(') {


					while (!(stack.peek() == '(')) {

						// append to post until
						p = stack.pop();
						post += " " + p;

					}
				}
				// discard '('
				stack.pop();

			// handle right-hand bracket
			} else if (c == '}') {

				char p = ' ';

				// if stop of stack does not equal left bracket
				if (stack.peek() != '{') {

					// append to post until bracket found
					while (!(stack.peek() == '{')) {

						p = stack.pop();
						post += " " + p;
					}
				}
				// discard '{'
				stack.pop();

			// Handle operators
			} else if (c == '+' || c == '-'
					|| c == '*' || c == '/') {

				// add space to post string
				post += " ";

				/* pop the stack and add it to post
				 * variable while stack is empty and
				 * priority of stack is higher than c.
				 */
				while (!stack.isEmpty()
						&& (precedence.get(stack.peek())
						>= precedence.get(c))) {

					char p = stack.pop();
					post += " " + p;

				}
				// push operator to the stack
				stack.push(c);
			}
		}

		// adds remaining operators from stack to the post variable.
		while (!stack.isEmpty()) {

			char p = stack.pop();
			post += " " + p;

		}

		return post;

	}

	/**
	 * load hash map with operator and key value pairs for precedence.
	 */
	public static void loadPrecedence() {
		precedence.put('+', 1);
		precedence.put('-', 1);
		precedence.put('*', 2);
		precedence.put('/', 2);
		precedence.put('(', 0);
		precedence.put('{', 0);
	}

}
