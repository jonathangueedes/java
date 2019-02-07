package java;

import java.util.ArrayList;
import java.util.Scanner;

public class FttAcumulador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("FTT Acumulador");
		System.out.println("I ai mano...");
		
		
		ArrayList<String> userMessages = new ArrayList<>();
		
		
		
		Scanner scan = new Scanner(System.in);
			
		int acumulador  = 0;
		
		while(scan.hasNext()){
			
			String userText = scan.nextLine();
			
			if(userText.isEmpty())
				break;
			try{
			
			acumulador += Integer.valueOf(userText);
			}
			catch(Exception e ){
				System.err.println("Ops!!");
				e.printStackTrace();
			}
			
			System.out.println("Valor acumulado: " + acumulador);
			
		}
		
		scan.close();
		
		for (int x = 0; x < userMessages.size(); x ++){
			System.out.println(userMessages.get(x));
		}

	}
	

}
