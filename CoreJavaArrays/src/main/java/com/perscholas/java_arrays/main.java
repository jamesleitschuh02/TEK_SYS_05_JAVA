package com.perscholas.java_arrays;

import java.util.Arrays;

public class main {

	public static void main(String[] args) {
		// Core Java - Arrays
		
		// 1
		
		int[] myNum = {1,2,3};
		for(int i = 0; i < myNum.length; i++) {
			System.out.println(myNum[i]);
		}
		
		// 2
		
		int[] arr2 = {13,5,7,68,2};
		
		// 3
		
		String[] arr3 = {"red", "green", "blue", "yellow"};
		System.out.println(arr3.length);
		String[] arr4 = arr3.clone();
		System.out.println(Arrays.toString(arr4));
		
		
		// 4
		
		int[] arr5 = {1,2,3,4,5};
		System.out.println(arr5[0] + ", " + arr5[arr5.length - 1]);
		
		// Array at index 5 errors, index 5 does not exist in arr5
		
		// 5
		
		int[] arr6 = new int[5];
		for(int i = 0; i < arr6.length; i++) {
			arr6[i] = i;
			System.out.println(arr6[i]);
		}
		
		// 6
		
		int[] arr7 = new int[5];
		for(int i = 0; i < arr7.length; i++) {
			arr7[i] = i * 2;
			System.out.println(arr7[i]);
		}
		
		// 7
		
		int[] arr8 = {1,2,3,4,5};
		for(int i = 0; i < arr8.length; i++) {
			if (i != 2) {
				System.out.println(arr8[i]);
			}
		}
		
		
		// 8
		
		String[] arr9 = {"red", "green", "blue", "yellow", "green"};
		String temp = arr9[0];
		arr9[0] = arr9[2];
		arr9[2] = temp;
		System.out.println(Arrays.toString(arr9));
		
		// 9
		
		int[] myNum2 = {4,2,9,13,1,0};
		for(int i = 0; i < myNum2.length; i++) {
			int temp1;
			for (int x = 1 + i; x <= myNum2.length; x++) {
				if (x >= myNum2.length) {
					break;
				}
				if (myNum2[i] > myNum2[x]) {
					temp1 = myNum2[i];
					myNum2[i] = myNum2[x];
					myNum2[x] = temp1;
				}
			}
		}
		System.out.println("Array in ascending order: " + Arrays.toString(myNum2));
		System.out.println("The smallest number is " + myNum2[0]);
		System.out.println("The largest number is " + myNum2[myNum2.length - 1]);
		
		// 10 
		// Create an array that includes an integer, 3 strings, and 1 double. Print the array.
		
		
		
		

	} //

} //
