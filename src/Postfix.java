import java.util.Scanner;

public class Postfix<T> {

	public Stack stack;

	public Postfix() {
		stack = new Stack();
	}

	public int evaluate(String pfx) throws Underflow {
		String[] tokens = pfx.split("");
		int rhs; // right hand side
		int lhs; // left hand side

		// loop through chars array and print out values separated with a space

		for (int i = 0; i < tokens.length; i++) {

			String t = tokens[i];

			if (isInteger(t)) // if is operand
				stack.push(t);

			else if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/") || t.equals("^")) { // else
																											// if
																											// is
																											// operator

				rhs = Integer.parseInt("" + stack.pop());
				lhs = Integer.parseInt("" + stack.pop());

				switch (t) {
				case "+":
					stack.push(lhs + rhs);
					break;
				case "-":
					stack.push(lhs - rhs);
					break;
				case "*":
					stack.push(lhs * rhs);
					break;
				case "/":
					stack.push(lhs / rhs);
					break;
				case "^":
					stack.push(Math.pow(lhs, rhs));
					break;

				default:
					System.out.println("Something went wrong. No such operator.");
				}
			}
		}

		int result = Integer.parseInt("" + stack.pop());

		if (stack.isEmpty()) {
			return result;
		} else {
			System.out.println("Something went wrong. Stack is not empty after calculation.");
			return -1;
		}
	}

	private static boolean isInteger(String t) {
		boolean isInteger = false;
		try {
			Integer.parseInt(t);
			isInteger = true; // parse to int worked
		} catch (NumberFormatException ex) { // parsing didn't work
		}
		return isInteger;
	}

	public String infixToPostfix(String ifx) throws Underflow { // Given a
																// sequence of
																// tokens s and
																// a result r
		String result = "";
		String[] tokens = ifx.split("");

		for (int i = 0; i < tokens.length; i++) { // While s is not empty:

			String t = tokens[i]; // Let t = next token.

			if (isInteger(t)) { // If t is an operand, r = r + t;
				result = result + t;
			} else if (t.equals("(")) { // If t is an open parenthesis, push it.
				stack.push(t);
			} else if (t.equals(")")) { // If t is a close parenthesis:
				while (stack.top() != "(") { // while top <> open parenthesis
					result = result + stack.top(); // r = r + top
					stack.pop(); // pop
				}
				stack.pop(); // pop // removes the open parenthesis
			} else if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/") || t.equals("^")) { // If
																											// t
																											// is
																											// an
																											// operator
				try {
					while (!(getPrecedence((String) stack.top()) < getPrecedence(t))
							|| getPrecedence((String) stack.top()) == getPrecedence(t)) {
						result = result + stack.top(); // r = r + top
						stack.pop(); // pop
					}
				} catch (NullPointerException n) {
					// if stack is empty
				}
				stack.push(t); // push t

			}

		}
		while (!stack.isEmpty()) { // while stack not empty
			result = result + stack.top(); // r = r + top
			stack.pop(); // pop
		}

		return result;
	}

	public int getPrecedence(String s) {
		String precedence = "+-*/^";
		int precedenceS = precedence.indexOf(s);

		if (precedenceS < 2)
			precedenceS = 0;
		else if (precedenceS == 4)
			precedenceS = 2;
		else
			precedenceS = 1;

		return precedenceS;
	}

	public void consoleCalc() throws Underflow {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String input = scanner.next();
			if (input.equals("bye"))
				break;

			System.out.println(evaluate(input));

		}

	}

}