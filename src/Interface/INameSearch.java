package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface INameSearch extends Remote{
	public String getNames(String[] lastnames) throws RemoteException;
}
