package functionalInterfaces;

public class SendingThread {

	private String message;
	
	Sender sender;
	
	public SendingThread(String msg, Sender send){
		this.message = msg;
		this.sender = send;
	}
	
	public void run() {
		synchronized(sender) {
			sender.send(message);
		}
	}
}
