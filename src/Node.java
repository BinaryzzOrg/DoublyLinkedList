
public class Node {
	private int data;
	private Node next;
	private Node prev;

	public Node(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}// end constructor

	// getter setters
	int getData() {
		return this.data;
	}// end method

	void setData(int data) {
		this.data = data;
	}// end method

	Node getNext() {
		return this.next;
	}// end method

	void setNext(Node next) {
		this.next = next;
	}// end method

	Node getPrev() {
		return this.next;
	}// end method

	void setPrev(Node prev) {
		this.prev = prev;
	}// end method
}// end class