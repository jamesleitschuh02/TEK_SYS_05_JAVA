package functionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@FunctionalInterface
interface AddMethod{
//	void msg();
	public int add(int a, int b);
}

public class Main {

	public static void main(String[] args) {
		
		// String Joiner
		
//		StringJoiner joinNames = new StringJoiner(",","[","]");
//		
//		// Add method from the String Joiner
//		
//		joinNames.add("James");
//		joinNames.add("John");
//		joinNames.add("Joe");
//		joinNames.add("Joseph");
//		
//		System.out.println(joinNames);
//		
//		StringJoiner joinName2 = new StringJoiner("-","(",")");
//		joinName2.add("Joe");
//		joinName2.add("Dana");
//		
//		StringJoiner m = joinName2.merge(joinNames);
//		
//		System.out.println(m);
		
		///////////////////////////////////////////////////////////////////////////
		
		// String Buffer
		
//		StringBuffer sb = new StringBuffer("Hello ");
//		sb.append("True");
//		sb.insert(3, " false ");
//		sb.replace(1,3,"Je");
//		sb.delete(0,2);
//		sb.reverse();
//		
//		System.out.println(sb);
		
		////////////////////////////////////////////////////////////////////////////
		
		// Functional Interfaces & Lamb-duhsss
		
//		String say = "Hello";
		
//		AddMethod me =()->{
//			System.out.println(say);
//		};
//		
//		me.msg();
		
//		AddMethod addOne = (a,b)->{
//			System.out.println(a+b);
//		};
		
//		List<String> listOne = new ArrayList<>();
//		listOne.add("james");
//		listOne.add("james");
//		listOne.add("james");
//		listOne.add("james");
//		
//		listOne.forEach((n)->System.out.println(n));
		
		/////////////////////////////////////////////////////////////////////////////
		
//		RunnableMyDemo runOne = new RunnableMyDemo("Thread-1");
//		
//		runOne.start();
//		
//		RunnableMyDemo runTwo = new RunnableMyDemo("Thread-2");
//		
//		runTwo.start();
		
		Sender send = new Sender();
		SendingThread sendOne = new SendingThread("Thread 1 sending", send);
		SendingThread sendTwo = new SendingThread("Thread 2 sending", send);
		
		sendOne.run();
		sendTwo.run();
	}
	

//	@Override
//	public void msg(String msg) {
//		System.out.println("Hello");
//		
//	}

}
