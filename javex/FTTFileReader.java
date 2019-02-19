package javex;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;



public class FTTFileReader {
	
	
	public static void main(String[] args) {
		
		Path path = Paths.get("c:\\users\\082160036\\Desktop\\javex.csv");
		
		try{
			
			BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset());
			String line = null;
			
			while ((line = reader.readLine()) != null)
				System.out.println(line);
			
		} catch(Exception e){
			e.printStackTrace();
		}

		
	}
	
	
	

}
