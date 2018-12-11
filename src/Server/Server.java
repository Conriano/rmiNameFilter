package Server;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import Interface.INameSearch;

public class Server {

public static void main(String[] args) throws RemoteException, MalformedURLException {
	    
	INameSearch server = new NameSearch();
	INameSearch stub = (INameSearch) UnicastRemoteObject.exportObject((INameSearch) server, 0);
	
	Registry registry = LocateRegistry.createRegistry(1099);
	registry.rebind("NameSearch", stub);
	  
    System.out.println("Server started...");
  }

}
