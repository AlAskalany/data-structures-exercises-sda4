package exercise;

class Node {
	int elem;
	Node next;
	
	Node(int i, Node n) {
		elem = i;
		next = n;
	}
}

public class LinkedList {

	// storage for elements
	Node first;
	
	public LinkedList() {
		first = null;
	}
	
	/**
	 * Adds an integer to the end of this list.
	 *
	 * @param i the integer to add
	 */
	void add(int i) {
		Node newNode = new Node(i, null);
		
		if (first == null) { // list is empty
			first = newNode;
		} else { // list is not empty
			// 1. step find the last node
			Node current = first;
			
			while (current.next != null) {
				// current is not the last node!
				current = current.next;
			}
			// current.next == null
			// that means that current is the last node! YAY! :-)
			
			// 2. step insert new node
			current.next = newNode;			
		}
	}

	/**
	 * Return element at given index.
	 * 
	 * @param index
	 * @return element at index
	 * @throws {@link IndexOutOfBoundsException} if index is negative
	 */
	int get(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		int i = 0;
		Node current = first;
		
		while (index != i && current.next != null) {
			i++;
			current = current.next;
		}
		
		if (index <= i) {
			// here, we are at the right place!
			return current.elem;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	void printAll() {
		if (first == null) { // list is empty
			System.out.print("<empty>");
		} else {
			// we know that first is not null!
			System.out.print("[");
		
			Node current = first;
			while (current.next != null) {
				System.out.print(current.elem + ",");
				current = current.next;
			}
			// print last element
			System.out.print(current.elem);
		
			System.out.print("]");
		}
	}
}
