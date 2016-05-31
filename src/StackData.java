
public class StackData<T> {
	private T data;
	private StackData<T> next;

	public StackData(T data, StackData<T> next) {

		this.setData(data);
		this.setNext(next);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public StackData<T> getNext() {
		return next;
	}

	public void setNext(StackData<T> next) {
		this.next = next;
	}

}
