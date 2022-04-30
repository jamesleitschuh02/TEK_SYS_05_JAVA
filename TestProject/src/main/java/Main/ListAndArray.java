package Main;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.LinkedList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ListAndArray {
    public static void main(String [] args) {

        // List<String> numbers
        //     = Arrays.asList("x/", "y/", "../", "z/", "./");
            
    //     List<String> numbers
    //             = Arrays.asList("o/", "w/", "e/", "./", "./", "./");
 
    //     int moves = 0;
    //     for (String i : numbers){
    //         if (i == "../"){
    //             moves--;
    //         }
    //         else if (i == "./"){
    //             continue;
    //         }
    //         else {
    //             moves++;
    //         }
    //          }
    //      System.out.println(moves);

        // LinkedList<Integer> myLinkedList = new LinkedList<>();
        // myLinkedList.add(34);
        // myLinkedList.add(24);
        // // myLinkedList.add(3,14);
        // myLinkedList.get(1);

        // EnumMap<DayOfWeek, Integer> map = new EnumMap<>(DayOfWeek.class);
        // map.put(DayOfWeek.FRIDAY, 23);

        // HashMap<Integer, Integer> cars = new HashMap<>();
        // cars.containsValue(cars);
        // cars.containsKey(cars);

        // HashSet<String> setHashList = new HashSet<>();
        // setHashList.add("one");
        // setHashList.add("two");
        // setHashList.add("three");
        // setHashList.add("four");
        // setHashList.add("five");

        // Iterator<String> itr = setHashList.iterator();

        // while(itr.hasNext()) {
        //     System.out.println(itr.next());
        // }

        int a = 7;
        int b = 2;
        System.out.println(a/b);
    }    
}