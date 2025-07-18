package com.jst.linkedlist;

import java.util.Scanner;

public class LinkedListMain {

	public LinkedListNode head;

	public LinkedListNode insertInBeg(int key, LinkedListNode head) {
		LinkedListNode ttmp = new LinkedListNode(key);

		if (head == null)
			head = ttmp;

		else {
			ttmp.next = head;
			head = ttmp;
		}
		return head;
	}

	public LinkedListNode insertInEnd(int key, LinkedListNode head) {
		LinkedListNode ttmp = new LinkedListNode(key);
		LinkedListNode ttmp1 = head;

		if (ttmp1 == null)
			head = ttmp;
		else {
			while (ttmp1.next != null)
				ttmp1 = ttmp1.next;
			ttmp1.next = ttmp;

		}

		return head;

	}

	public LinkedListNode insertAtPos(int key, int pos, LinkedListNode head) {
		LinkedListNode ttmp = new LinkedListNode(key);

		if (pos == 1) {
			ttmp.next = head;
			head = ttmp;
		} else {
			LinkedListNode ttmp1 = head;
			for (int i = 1; ttmp1 != null && i < pos; i++)
				ttmp1 = ttmp1.next;
			ttmp.next = ttmp1.next;
			ttmp1.next = ttmp;
		}

		return head;
	}

	public LinkedListNode delete(int pos, LinkedListNode head) {
		LinkedListNode ttmp = head;
		if (pos == 1)
			head = ttmp.next;
		else {
			for (int i = 1; ttmp != null && i < pos - 1; i++)
				ttmp = ttmp.next;
			ttmp.next = ttmp.next.next;
		}
		return head;
	}

	public int length(LinkedListNode head) {
		LinkedListNode ttmp = head;
		int c = 0;
		if (ttmp == null)
			return 0;
		else {
			while (ttmp != null) {
				ttmp = ttmp.next;
				c++;
			}
		}
		return c;
	}

	public LinkedListNode reverse(LinkedListNode head) {
		LinkedListNode prevLNode = null, curLNode = head, nextLNode = null;
		while (curLNode != null) {
			nextLNode = curLNode.next;
			curLNode.next = prevLNode;

			prevLNode = curLNode;
			curLNode = nextLNode;
		}

		head = prevLNode;
		return head;
	}

	public void display(LinkedListNode head) {
		LinkedListNode ttmp = head;
		while (ttmp != null) {
			System.out.print(ttmp.data + " ");
			ttmp = ttmp.next;
		}
	}

	public static void main(String[] args) {
		LinkedListMain l = new LinkedListMain();
		l.head = null;
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("n********* MENU *********");
			System.out.println("1.Insert In End");
			System.out.println("2.Insert In Beg");
			System.out.println("3.Insert At A  Particular Pos");
			System.out.println("4.Delete At a Pos");
			System.out.println("5.Length");
			System.out.println("6.Reverse");
			System.out.println("7.Display");
			System.out.println("8.EXIT");
			System.out.println("Enter Your Choice : ");
			int n = in.nextInt();
			switch (n) {
			case 1:
				System.out.println("Enter the Value : ");
				l.head = l.insertInEnd(in.nextInt(), l.head);
				break;
			case 2:
				System.out.println("Enter the Value : ");
				l.head = l.insertInBeg(in.nextInt(), l.head);
				break;
			case 3:
				System.out.println("Enter the Value : ");
				l.head = l.insertAtPos(in.nextInt(), in.nextInt(), l.head);
				break;
			case 4:
				l.head = l.delete(in.nextInt(), l.head);
				break;
			case 5:
				System.out.println(l.length(l.head));
				break;
			case 6:
				l.head = l.reverse(l.head);
				break;
			case 7:
				l.display(l.head);
				break;
			case 8:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong Choice!");
				break;
			}
			System.out.println("Do You Wanna Cont......... ");
		} while (in.nextInt() == 1);

	}
}
