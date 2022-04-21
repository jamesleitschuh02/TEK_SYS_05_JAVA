package Main;

public class Main {

	public static void main(String[] args) {
		
		KidUsers kid1 = new KidUsers(10,"Kids");
		KidUsers kid2 = new KidUsers(18,"Fiction");
		
		AdultUser adult1 = new AdultUser(5,"Kids");
		AdultUser adult2 = new AdultUser(23,"Fiction");
		
		System.out.println(kid1.registerAccount());
		System.out.println(kid2.registerAccount());
		System.out.println(kid1.requestBook());
		System.out.println(kid2.requestBook());
		
		System.out.println(adult1.registerAccount());
		System.out.println(adult2.registerAccount());
		System.out.println(adult1.requestBook());
		System.out.println(adult2.requestBook());
	}

}
