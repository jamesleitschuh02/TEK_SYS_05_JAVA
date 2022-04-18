package com.perscholas.java_operations;

public class main {

	public static void main(String[] args) {
		// 1
		
		//decimal to Binary
		
		// 1 -> 1
		// 8 -> 1000
		// 33 -> 100001
		// 78 -> 1001110
		// 787 -> 1100010011
		// 33987 -> 1000010011000011
		
		// 2
		
		// Binary to Decimal
		
		// 0010 -> 2
		// 1001 -> 9
		// 0011 0100 -> 52
		// 0111 0010 -> 114
		// 0010 0001 1111 -> 543
		// 0010 1100 0110 0111 -> 11367
		
		// 3
		
		int x = 2;
		System.out.println(Integer.toBinaryString(x));
		x = x << 1;
		System.out.println(Integer.toBinaryString(x));
		
		// x = 9
		x = 225;
		System.out.println(Integer.toBinaryString(x));
		x = x << 1;
		System.out.println(Integer.toBinaryString(x));
		
		// x = 17
		x = 1555;
		System.out.println(Integer.toBinaryString(x));
		x = x << 1;
		System.out.println(Integer.toBinaryString(x));
		
		// x = 88
		x = 1555;
		System.out.println(Integer.toBinaryString(x));
		x = x << 1;
		System.out.println(Integer.toBinaryString(x));
		
		// 4
		
		x = 150;
		System.out.println(Integer.toBinaryString(x));
		x = x >> 2;
		System.out.println(Integer.toBinaryString(x));
		
		// x = 225
		x = 225;
		System.out.println(Integer.toBinaryString(x));
		x = x >> 2;
		System.out.println(Integer.toBinaryString(x));
		
		// x = 1555
		x = 1555;
		System.out.println(Integer.toBinaryString(x));
		x = x >> 2;
		System.out.println(Integer.toBinaryString(x));
		
		// x = 32456
		x = 32456;
		System.out.println(Integer.toBinaryString(x));
		x = x >> 2;
		System.out.println(Integer.toBinaryString(x));
		
		// 5
		
		x = 7;
		int y = 17;
		int z;
		
		// 6
		
		x = 9;
		System.out.println(x);
		x++;
		System.out.println(x);
		
		// 7
		
		x = 0;
		System.out.println(x);
		x = x + 1;
		System.out.println(x);
		x++;
		System.out.println(x);
		++x;
		System.out.println(x);
		
		// 8
		
		x = 5;
		y = 8;
		int sum = ++x + y;
		System.out.println(sum);
		
		x = 5;
		y = 8;
		int sum2 = x++ + y;
		System.out.println(sum2);
	}

}
