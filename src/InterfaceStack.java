
public interface InterfaceStack<T> {

	
		
		public void push(T x) throws Overflow;	
		public T pop() throws Underflow;	
		public T top() throws Underflow;	
		public boolean isEmpty();	
		public void makeEmpty(); 

	
	
	
}
