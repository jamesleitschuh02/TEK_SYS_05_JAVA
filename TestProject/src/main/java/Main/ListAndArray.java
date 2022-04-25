package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAndArray {
    public static void main(String [] args) {
        // List<Integer> myNumList;

        ArrayList<Integer> myNumList = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            myNumList.add(i);
        }
        int sum = 0;
        for(Integer i : myNumList) {
            sum += i;
        }

        System.out.println(sum);

        myNumList.sort((x,y) -> x.compareTo(y));

        List<Double> listOfDoubles = Arrays.asList(2.0,2.7,2.6);
        System.out.println(listOfDoubles.getClass().getName());

        List<String> str = new ArrayList<>();
        str.add("a string");
        System.out.println(str.get(0));
    }
    
}