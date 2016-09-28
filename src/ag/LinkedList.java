package ag;

public class LinkedList {

	Node head; // head of list

	/* Linked list Node */
	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/* Inserts a new Node at front of the list. */
	void push(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	/* Function to reverse the linked list */
	void reverseList() {
		Node current = head;
		Node prev = null;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	/* Function to print linked list */
	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		 
        /* Constructed Linked List is 12->15->10->11->
           5->6->2->3 */
        llist.push(20);
        llist.push(2);
        llist.push(6);
        llist.push(5);
        llist.push(11);
        llist.push(10);
        llist.push(15);
        llist.push(13);
        
        llist.printList();
        
        llist.delNodesValue(10);
 
        System.out.println("Modified Linked List");
        llist.printList();

	}

	private void delNodesValue(int val) {
		while (head != null && head.data >= val) {
			head = head.next;
		}
		Node curr = head;
		Node prev = head;
		while (curr != null) {
			// System.out.print(temp.data + " ");

			if (curr.data >= val) {
				// System.out.println("if");
				prev.next = curr.next;
				curr = curr.next;
			} else {
				// System.out.println("else");
				prev = curr;
				curr = curr.next;
			}
		}
		System.out.println();

	}

}
