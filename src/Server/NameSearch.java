package Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Interface.INameSearch;

public class NameSearch implements INameSearch{

	@Override
	public String getNames(String[] prenames) {
		
		File file = new File("./src/Server/names.txt"); 
		  
		BufferedReader br;
		String names = "";
		String result = "";
		
		try {
			br = new BufferedReader(new FileReader(file));
			
			while ((names = br.readLine()) != null) {
				String[] nameArray = names.split(" ");
				for(String prename : prenames) {
					
					if(nameArray[1].equals(prename)) {
						result += nameArray[0] + " " + nameArray[1] + "\n";
					}
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
