import java.util.Scanner;

public class Main {

	// field object
	static DoublyLinkedList linkList = new DoublyLinkedList();

	public static void main(String[] args) {
		DisplayMenu(linkList);
	}// end main

	static void DisplayMenu(DoublyLinkedList linkList) {

		Scanner sc = new Scanner(System.in);
		//@formatter:off
		System.out.print("\n {Midterm Lab Exam} \n" + 
						"[0] Append \n"+ 
						"[1] Display \n"+ 
						"[2] Delete \n"+ 
						"[3] Insert \n"+ 
						"[4] Display Unique \n"+ 
						"[5] Exit \n" +
						": ");
		//@formatter:on

		switch (linkList.GetUserInput()) {
		case 0: {// append

			// call append method
			linkList.append();
			break;
		}
		case 1: {// display

			// call display method that shows index 1 of confirmationMsg array
			linkList.display(1);
			break;
		}
		case 2: {// delete
			linkList.delete();
			break;
		}
		case 3: {// insert
			// calls insert method
			linkList.insert();
			break;
		}
		case 4: {// display unique
			// call display unique method
			linkList.listThatIsNotDuplicate();
			break;
		}
		case 5: {// exit
			// close program
			System.exit(0);
			break;
		}
		default:
			// errorMsg if input checker fails
			System.out.println("Only enter [0], [1], [2], [3], [4], [5]");
		}// end switch

		// call the menu again passing the same linkList object
		DisplayMenu(linkList);
	}// end method

}// end class
