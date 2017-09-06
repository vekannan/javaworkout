package com.prep.java.datastructure;

public class LinkedList {
	static Node head;
	public static void main(String args[]){
		head = new Node(1);
		Node node2 = new Node(10);
		Node node3 = new Node(8);
		head.next = node2;
		node2.next = node3;
		printList();
	}
	
	public static void printList()
    {
        Node n = head;
        while (n != null)
        {
            System.out.print(n.data+" ");
            n = n.next;
        }
    }
}
