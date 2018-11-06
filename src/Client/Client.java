package Client;

import java.rmi.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Interface.INameSearch;

public class Client {

	static String sendRequest(String ip, String[] names) {
		Registry registry;
		String resultNames = "";
		String registryEntry = "NameSearch";
		
		try {
			registry = LocateRegistry.getRegistry(ip, 1099);
			INameSearch server = (INameSearch) registry.lookup(registryEntry);
			resultNames = server.getNames(names);
		} catch(ConnectException e) {
			System.err.println("Could not reach ip '" + ip + "'");
		} catch (RemoteException e) {
			System.err.println("Could not reach remote");
		} catch(NotBoundException e) {
			System.err.println("Could not find a registry entry for '" + registryEntry + "'");
		} 
		
		return resultNames;
	}
	
	
	
}
