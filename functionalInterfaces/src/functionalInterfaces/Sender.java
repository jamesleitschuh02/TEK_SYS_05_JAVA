package functionalInterfaces;

public class Sender {
	
	public void send(String message) {
		try {
			Thread.sleep(50);
		}catch(Exception e) {
			System.out.println("Thread interrupted");
		}
		System.out.println("\n" + message + " sent");
	}
	
}
