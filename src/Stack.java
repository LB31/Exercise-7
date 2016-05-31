public class Stack<T> implements InterfaceStack<T> {
	private StackData<T> first = null;

	public Stack() {
		// TODO Auto-generated constructor stub
	}

	public void tester(T para1, T para2) {
		push(para1);
		push(para2);
		System.out.println(isEmpty());
		System.out.println(toString());
		System.out.println(top());
		pop();
		System.out.println(top());
		makeEmpty();
		System.out.println(isEmpty());

	}

	@Override
	public void push(T data) {

		first = new StackData<>(data, first);

	}

	@Override
	public T top() throws Underflow {
		if (first != null)
			return first.getData();
		else
			throw new Underflow("There is nothing on the top");

	}

	@Override
	public T pop() throws Underflow {
		if (first != null) {
			T giveBack = first.getData();
			first = first.getNext();
			return giveBack;
		} else
			throw new Underflow("The stack is empty");

	}

	@Override
	public boolean isEmpty() {
		if (first == null)
			return true;
		else
			return false;
	}

	@Override
	public void makeEmpty() {
		first = null;

	}

	@Override
	public String toString() {
		String theStack = "";
		StackData<T> active = first;
		while (active != null) {
			theStack += active.getData() + " ";
			active = active.getNext();

		}
		return theStack;

	}

	public StackData<T> getFirst() {
		return first;
	}

	public static void main(String[] args) {
		Stack test = new Stack();

		// for (long i = 0; i < 10; i++) {
		//
		//
		// }
		// int number = Integer.parseInt("" + test.pop());
		// int number2 = Integer.parseInt("" + test.pop());
		// test.push(number * number2);
		// Object bla = test.first.getData();
		// System.out.println(test.pop());
		// System.out.println(test.toString());

		//
		// test.tester("Hi", 5);
		// test.push(5);
		// System.out.println(test.toString());
		// test.pop();

		try {
			System.out.println(test.pop());
		} catch (Underflow e) {
			System.out.println(e.getMessage());

		}

		// System.out.println(test.top());
		// System.out.println(test.pop());

		char[] precedence = { '+', '-', '*', '/' };
		String t = "+";

		test.push('*');

		int precedenceTop = new String(precedence).indexOf((char) test.top());
		if (precedenceTop < 2)
			precedenceTop = 0;
		else
			precedenceTop = 1;

		int precedenceT = new String(precedence).indexOf(t);
		if (precedenceT < 2)
			precedenceT = 0;
		else
			precedenceT = 1;

		System.out.println(precedenceTop);
		System.out.println(precedenceT);

	}

}
