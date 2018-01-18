package com.prep.java.datastructure;

public class Node {
	int data;
	Node next;
	Node rightNode;
	/**
	 * @return the rightNode
	 */
	public Node getRightNode() {
		return rightNode;
	}
	/**
	 * @param rightNode the rightNode to set
	 */
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	/**
	 * @return the leftNode
	 */
	public Node getLeftNode() {
		return leftNode;
	}
	/**
	 * @param leftNode the leftNode to set
	 */
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	Node leftNode;
	Node(int nodeValue){
		data = nodeValue;
		next = null;
		leftNode = null;
		rightNode = null;
	}
	
	
}
