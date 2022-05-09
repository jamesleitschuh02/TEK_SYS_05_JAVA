package linkedList;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {

	public static void main(String[] args) {
		
		List<Integer> test = new ArrayList<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		
		countNumberOfSubarrays(test);
		

	}
	
    public static void countNumberOfSubarrays(List<Integer> arr) {

    	for (int i = 0; i < arr.size(); i++) {
    		for (int x = i; x <= arr.size(); x++) {
    			if (x == i) {
    				List<Integer> arr2 = new ArrayList<>();
    				arr2.add(arr.get(x));
    				System.out.println(arr2);
    			}
    			else {
    				List<Integer> arr2 = arr.subList(i, x);
    				System.out.println(arr2);
    			}
           
    		}
    	}
    }

}
