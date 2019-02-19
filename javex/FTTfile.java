package javex;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class FTTfile {

	public static void main(String[] args) {
		
		System.out.println("FTT File...");
		System.out.println(System.getProperties());
		 
		 	Random rn = new Random();
		 	
		 	try{
		 		
		 		PrintWriter writer = new PrintWriter("c:\\users\\082160036\\Desktop\\javex.csv","UTF-8");
		 		
		 		int contador = 0;
		 		
		 		do {
		 			
		 			writer.println(contador + ";" + rn.nextInt() + ";" + String.valueOf(rn.nextFloat()).replace('.', ','));
		 			contador++;
		 			
		 		} while (contador < 100 );
		 		
		 		writer.close(); //salva o arquivo
		 		
		 		
		 		
		 		
		 	} catch (FileNotFoundException e){
		 		
		 		System.err.println("Ops!");
		 		e.printStackTrace();
		 		
		 	} catch (UnsupportedEncodingException e) {
		 		
		 		System.err.println("Ops!");
		 		e.printStackTrace();
		 	}

	}

}
