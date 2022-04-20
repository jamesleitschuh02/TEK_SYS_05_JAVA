package Main;

public class Main {

	public static void main(String[] args) {
		
		// Program at the "interface" defined in the superclass
		// Declare instances of the superclass, substituted by subclasses

		Monster m1 = new FireMonster("badFire");
		Monster m2 = new StoneMonster("badStone");
		Monster m3 = new WaterMonster("badWater");
		
		// Invoke the actual implementation
		
		System.out.println(m1.attack());
		System.out.println(m2.attack());
		System.out.println(m3.attack());
		
		// m1 dies, generate a new instance and re-assign to m1
		m1 = new StoneMonster("badStone2");
		System.out.println(m1.attack());
		
		// We have a problem!
		Monster m4 = new Monster("normalMonster");
		System.out.println(m4.attack());
	}

}