package com.jst.linkedlist;

public class LinkedList {

	private Link first;

	public LinkedList() {
		first = null;
	}

	public void insertFirst(int key, int data) {
		Link link = new Link(key, data);
		link.next = first;
		first = link;
	}

	public Link deleteFirst() {
		Link tempLink = first;
		first = first.next;
		return tempLink;
	}

	public void display() {
		Link current = first;
		System.out.print("[ ");
		while (current != null) {
			current.display();
			current = current.next;
			System.out.print(" ");
		}
		System.out.print(" ]");
	}

	public Link find(int key) {
		Link current = first;

		if (first == null) {
			return null;
		}

		while (current.key != key) {
			if (current.next == null) {
				return null;
			} else {
				current = current.next;
			}
		}
		return current;
	}

	public Link delete(int key) {
		Link current = first;
		Link previous = null;
		if (first == null) {
			return null;
		}

		while (current.key != key) {
			if (current.next == null) {
				return null;
			} else {
				previous = current;
				current = current.next;
			}
		}

		if (current == first) {
			first = first.next;
		} else {
			previous.next = current.next;
		}
		return current;
	}

	// is list empty
	public boolean isEmpty() {
		return first == null;
	}

	public int length() {
		int length = 0;
		for (Link current = first; current != null; current = current.next) {
			length++;
		}
		return length;
	}

	public void sort() {
		int i, j, k, tempKey, tempData;
		Link current, next;
		int size = length();
		k = size;
		for (i = 0; i < size - 1; i++, k--) {
			current = first;
			next = first.next;
			for (j = 1; j < k; j++) {
				if (current.data > next.data) {
					tempData = current.data;
					current.data = next.data;
					next.data = tempData;

					tempKey = current.key;
					current.key = next.key;
					next.key = tempKey;
				}
				current = current.next;
				next = next.next;
			}
		}
	}

	public LinkedList reverse() {
		LinkedList reversedlist = new LinkedList();
		Link nextLink = null;
		reversedlist.insertFirst(first.key, first.data);
		Link currentLink = first;
		while (currentLink.next != null) {
			nextLink = currentLink.next;
			reversedlist.insertFirst(nextLink.key, nextLink.data);
			currentLink = currentLink.next;
		}
		return reversedlist;
	}

	public void concatenate(LinkedList list) {
		if (first == null) {
			first = list.first;
		}
		if (list.first == null) {
			return;
		}
		Link temp = first;

		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = list.first;
	}
}
