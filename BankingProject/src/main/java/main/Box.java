package main;

import java.util.ArrayList;
// have to include import for list
import java.util.List;

// Generic Class
public class Box <T>{
	
	List<T> values;
	
	public Box() {
		values = new ArrayList<T>();
	}
	
	public void add(T value) {
		values.add(value);
	}
	
	public List<T> get(){
		return values;
	}

}