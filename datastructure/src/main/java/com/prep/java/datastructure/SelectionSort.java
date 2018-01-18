package com.prep.java.datastructure;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		SelectionSort slectionSort = new SelectionSort();
		int array[] = {3,13,1,0,10,11,3};
		slectionSort.sort(array);
		slectionSort.printArray(array);
	}
	
	public void sort(int array[]){
		int length = array.length;
		for(int i = 0; i < length-1; i++){
			int min_index = i;
			for(int j = i+1 ; j <  length ; j++){
				if(array[j] < array[min_index])
					min_index = j;
				
			}
			int temp = array[min_index];
			array[min_index] = array[i];
			array[i] = temp;
		}
	}
	
	public void printArray(int array[]){
		for(int data: array){
			System.out.print(data);System.out.print('\t');
		}
	}

}
