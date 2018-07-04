package com.ebay.sample;


public class Fibonacci {
    public static long fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt("6");
       System.out.println(fibonacci(n));
       
    }
    
    private static void bubble(int[] ArrayObj){
    	for(int i=ArrayObj.length-1;i>=0;i--){
    		for(int j = 1;j <= i; j++ ){
    			int temp;
    			if(ArrayObj[j-1] > ArrayObj[j]){
    				temp = ArrayObj[j-1];
    				ArrayObj[j-1] = ArrayObj[j];
    				ArrayObj[j] = temp;
    			}
    		}
    	}
    }
    
    private static void insertion(int[] insObj){
    	for(int i = 0; i <= insObj.length-1; i++){
    		int min = i;
    		for(int j = i+1;j<insObj.length;j++){
    			if(insObj[min] > insObj[j] ) min = j; 
    		}
    	}
    }

}
