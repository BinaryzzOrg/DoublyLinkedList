import java.util.Scanner;

public class DoublyLinkedList {

	// field variables
	Scanner sc;
	private Node head;
	private Node tail;
	int numElements = 0;

	// head getter
	Node getHead() {
		return this.head;
	}// end method

	// Msg getter and setter
	//@formatter:off
	String[] promptMsg = {"\nEnter a number: ",//0
						"\nEnter the position of the element to be deleted: ",//1
						"\nEnter the value to be removed: ",//2
						"\nEnter the value to be inserted",//3
						"\nEnter the position you want to insert:"};//4
	
	String[] confirmationMsg = {"The new element has been added successfully!",//0
						"\nThe current elements are: ",//1
						"The remaining elements are: ",//2
						"Successfully deleted all the occurences of the given value!"};//3
	
	String[] errorMsg = {"\n {Invalid Input!!}",//0
						"\n {Linkedlist is empty!!}",//1
						"\n {Invalid Position!!}",//2
						"\n {You don't have a list yet!!}",//3	
						"\n {Value not found!!}",//4
						"\n {Invalid position. Valid positions are from 1 to }"};//5
	//@formatter:on

	String GetPromptMsg(int index) {
		return promptMsg[index];
	}// end method

	String GetConfirmationMsg(int index) {
		return confirmationMsg[index];
	}// end method

	String GetErrorMsg(int index) {
		return errorMsg[index];
	}// end method

	int GetUserInput(int promptMsg) {
		sc = new Scanner(System.in);
		// call promptMsg array of specified index
		System.out.print(GetPromptMsg(promptMsg));
		// checks for other kind of input
		if (!sc.hasNextInt()) {
			System.out.println(GetErrorMsg(0));
			Main.DisplayMenu(Main.linkList);
		} // end if
		int userInput = sc.nextInt();
		return userInput;
	}// end method

	// overload
	int GetUserInput() {

		sc = new Scanner(System.in);

		// checks for other kind of input
		if (!sc.hasNextInt()) {
			System.out.println(GetErrorMsg(0));
			Main.DisplayMenu(Main.linkList);
		} // end if

		// check if input is on menu
		int userInput = sc.nextInt();
		if (!validateInput(userInput)) {
			System.out.println(GetErrorMsg(0));
			Main.DisplayMenu(Main.linkList);
		} // end if

		return userInput;
	}// end method

	boolean validateInput(int input) {

		// check if input is on menu 0-4
		if (input < 0 || input > 5) {
			// if if its outside the menu choices
			System.out.println(GetErrorMsg(0));
			return false;
		} // end method

		return true;
	}// end method

	boolean isThisNodeAvailable(Node node) {
		if (node != null) {
			return true;
		}
		return false;
	}// end method

	void createHead() {
		Node headNode = new Node(GetUserInput(0));
		head = headNode;
		System.out.println(GetConfirmationMsg(0));
		numElements++;
	}// end method

	void CreateTail() {
		Node tailNode = new Node(GetUserInput(0));
		head.setNext(tailNode);
		tailNode.setPrev(head);
		tail = tailNode;
		numElements++;
	}// end method

	// append
	void append() {

		// check for head
		if (!isThisNodeAvailable(head)) {
			createHead();
			return;
		} // end if else

		// check for tail
		if (isThisNodeAvailable(tail)) {
			Node newNode = new Node(GetUserInput(0));
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
			numElements++;
		} else {
			CreateTail();
		} // end if else

		System.out.println(GetConfirmationMsg(0));
	}// end method

	// display
	void display(int confirmationMsgIndex) {
		// check if the head has value
		if (head == null) {
			System.out.println(GetErrorMsg(1));
			return;
		} // end if

		Node currentNode = head;
		System.out.print(GetConfirmationMsg(confirmationMsgIndex));

		while (currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		} // end while

		System.out.println();
	}// end method

	// delete
	void delete(int position) {

		if (position < 1 || position > numElements) {
			System.out.println(GetErrorMsg(2));
			Main.DisplayMenu(Main.linkList);
			delete(sc.nextInt());

		} else if (position == 1) {
			head = head.getNext();

		} else {
			Node prev = head;
			int count = 1;
			while (count < position - 1) {
				prev = prev.getNext();
				count++;
			} // end while

			Node current = prev.getNext();
			prev.setNext(current.getNext());
			if (position == numElements) {
				tail = prev;
			} // end if
			numElements--;
		} // end if
	}// end method

	// insert
	void insert() {

		System.out.print(GetPromptMsg(3));
		int data = GetUserInput();

		System.out.print(GetPromptMsg(4));
		int position = GetUserInput();

		int listSize = count();

		if (position < 1 || position > listSize + 1) {
			System.out.println(GetErrorMsg(5) + (listSize + 1));
			return;
		} // end if
			// Initialize a pointer to the head of the linked list
		Node current = head;
		// Traverse the list to the node just before the target position
		for (int index = 0; index < position - 1; index++) {
			current = current.getNext();
		} // end for
			// Create a new node with the given data
		Node newNode = new Node(data);

		// Get a reference to the node that comes after the new node
		Node after = current.getNext();

		// Update the references to insert the new node into the list
		newNode.setNext(after);
		after.setPrev(newNode);
		current.setNext(newNode);
		newNode.setPrev(current);
	}// end method

	int count() {
		int count = 0;
		Node current = head;
		while (current != null) {
			count++;
			current = current.getNext();
		} // end while
		return count;
	}// end method

	// display unique
	void listThatIsNotDuplicate() {
		// boolean var to find the duplicate
		boolean foundDuplicateItem;
		System.out.println("\nList Without Duplicates: ");
		// assigned the usedToCompare to the first node while leave the
		// toAllNextNodes;since it will be initialized in the inner loop
		Node usedToCompare = head, toAllNextNodes;
		// outer loop to properly validates all the values
		// incase if the duplicate is not in adjacent pair
		for (usedToCompare = head; usedToCompare != null; usedToCompare = usedToCompare.getNext()) {
			// set to false for the boolean condition under to be run
			foundDuplicateItem = false;
			// inner loop that runs the next-next pointers
			// used for comparison
			for (toAllNextNodes = usedToCompare.getNext(); toAllNextNodes != null; toAllNextNodes = toAllNextNodes
					.getNext()) {
				// condition used to compare the curr and the next
				if (usedToCompare.getData() == toAllNextNodes.getData()) {
					// if found duplicate, make the foundDuplicate to true
					// So it will not print the duplicate item
					foundDuplicateItem = true;
					// immediately breaks the code once found duplicate
					break;
				} // end if
			} // end for
				// call the method to display the unique items
			displayUniqueItems(foundDuplicateItem, usedToCompare);
		} // end for
		System.out.println();
	}// end method

	void displayUniqueItems(boolean validateItem, Node currNode) {
		// if no more duplicates
		if (!validateItem) {
			// prints the non-duplicate items in the list
			System.out.print("[" + currNode.getData() + "]<->");
		} // end if
	}// end method

}// end class
