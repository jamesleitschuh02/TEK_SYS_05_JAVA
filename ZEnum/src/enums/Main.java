package enums;

import java.util.EnumSet;
import java.util.Iterator;

enum Planet{
	MERCURY(1), 
	VENUS(2), 
	EARTH(3),
	MARS(4),
	JUPIER(5),
	SATURN(6),
	URANUS(7),
	NEPTUNE(8),
	PLUTO(9);
	
	int number;
	
	Planet(int number){
		this.number = number;
	}
}

public class Main {

	public static void main(String[] args) {
		
		//basic enums
		Planet myPlanet = Planet.MARS;
		
		canILiveHere(myPlanet);
		
		//Enum sets
		EnumSet<Planet> planets = EnumSet.allOf(Planet.class);
		System.out.println(planets);
		
		EnumSet<Planet> l = EnumSet.noneOf(Planet.class);
		System.out.println(l);
		
		//range
		EnumSet<Planet> range = EnumSet.range(Planet.EARTH, Planet.JUPIER);
		System.out.println(range);
		
		//of:
		EnumSet<Planet> o = EnumSet.of(Planet.JUPIER);
		System.out.println(o);
		
		EnumSet<Planet> multiple = EnumSet.of(Planet.EARTH,Planet.MARS);
		System.out.println(multiple);
		
		//add and addAll
		EnumSet<Planet> plan1 = EnumSet.allOf(Planet.class);
		EnumSet<Planet> plan2 = EnumSet.noneOf(Planet.class);
		
		plan2.add(Planet.EARTH);
		
		plan2.addAll(plan1);
		
		System.out.println(plan2);
		
		//how to iterate
		
		Iterator<Planet> it = planets.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}

	}
	
	static void canILiveHere(Planet myPlanet) {
		
		switch(myPlanet) {
		case EARTH:
			System.out.println("You can live here");
			System.out.println("This is planet number " + myPlanet.number);
			break;
		default:
			System.out.println("You can't live here");
			System.out.println("This is planet number " + myPlanet.number);
			break;
		}
	}

}
