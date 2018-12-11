package Client;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dialog {
	
	Data data;
	
	public Dialog(Data data) {
		this.data = data;
	}
	
	private String MENU            = "Please make a choice: \n1) Insert remote's IP\n"
														   + "2) Type names (max. 10)\n" 
													       + "3) Send request\n" 
														   + "0) Bye\n";
	private String TYPE_IP_1       = "Type the remote's IP";
	private String TYPE_NAMES_2    = "Type the names to filter, seperate them by a blank";
	private String SEND_REQUEST_3  = "Requesting...";
	private String BYE_0		   = "See you\n";
	private String DEFAULT		   = "Wrong number, try again\n";
	private String INVALID		   = "Invalid input, try again\n";
	
	private int choice = 1;
	
	private Scanner sc;
	
	public void start() {
		
		sc = new Scanner(System.in);
		
		while(choice >= 1) {
			System.out.println(MENU);
			
			try {
				choice = sc.nextInt();
			}catch(InputMismatchException e) {
				System.err.println(INVALID);
				sc = new Scanner(System.in);
				continue;
			}
			
			select();
		}
	}
	
	private void select() {
		switch(choice) {
			case 1: System.out.println(TYPE_IP_1);
					readIp();
					break;
			case 2: System.out.println(TYPE_NAMES_2);
					readNames();
					break;
			case 3: System.out.println(SEND_REQUEST_3);
					sendRequest();
					break;
			case 0: System.out.println(BYE_0);
					System.exit(0);
					break;
			default: System.out.println(DEFAULT);
		}
	}
	
	private void readIp() {
		data.setIp(sc.next());
	}
	
	private void readNames() {
		sc = new Scanner(System.in);
		String names = sc.nextLine();
		data.setNames(names.split(" "));
		
		if(data.getNames().length > 10) {
			System.err.println("Too many names. 10 is maximum");
		}
	}
	
	private void sendRequest() {
		String names = Client.sendRequest(data.getIp(), data.getNames());
		if(names.isEmpty()) {
			System.out.println("Could not find any name\n");
			return;
		}
		System.out.println("Found following names: \n" + names + "\n");
	}
	
	
}
