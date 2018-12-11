package Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Interface.INameSearch;

public class NameSearch implements INameSearch{

	@Override
	public String getNames(String[] lastnames) {
		
		File file = new File("./src/Server/names.txt"); 
		  
		BufferedReader br;
		String names = "";
		String result = "";
		
		boolean[] foundNames = new boolean[lastnames.length];
		
		try {
			br = new BufferedReader(new FileReader(file));
			
			while ((names = br.readLine()) != null) {
				String[] nameArray = names.split(" ");
				for(int i = 0; i < lastnames.length; i++){
					
					if(nameArray[1].equals(lastnames[i])) {
						result += nameArray[0] + " " + nameArray[1] + "\n";
						foundNames[i] = true;
					}
				}
			} 
			
		for(int i = 0; i < foundNames.length; i++) {
			if(!foundNames[i]) {
				result += "Did not found prename for " + lastnames[i] + "\n";
			}
		}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
