package Client;

public class Launcher {

	private static Data data;
	
	public static void main(String[] args) throws Exception {
		
		data = new Data();
		Dialog dialog = new Dialog(data);
		dialog.start();
		
		System.out.println("Client terminated");
	}

}
