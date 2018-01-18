package com.prep.java.datastructure;

public class CreateBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []sortedArray = {1,2,3,4,5,6,7,8,9};
		CreateBST cbst = new CreateBST();
		cbst.createBSTNode(sortedArray, 0, sortedArray.length-1);
	}
	
	public Node createBSTNode(int[] array,int sIndex, int lIndex){
		
		if(sIndex > lIndex) return null;
		int mid = (sIndex + lIndex)/2;
		Node rootNode = new Node(array[mid]);
		rootNode.setLeftNode(createBSTNode(array,sIndex,mid-1));
		rootNode.setLeftNode(createBSTNode(array,mid+1,lIndex));
		return rootNode;
	}

}
