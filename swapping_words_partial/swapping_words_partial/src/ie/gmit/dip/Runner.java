package ie.gmit.dip;

import java.util.*;

//import java.util.ArrayList;
import java.io.*;

public class Runner {

	private static Scanner scanner;
	private static String userInput = new String();

	
	public static void main(String[] args) throws Exception {
	
		//AD NOTE - TRY TO SWAP THIS OUT FOR A BUFFERED READER AND SEE IF YOU CAN KEEP THIS GOING UNTIL THE USER WANTS TO QUIT
		scanner = new Scanner(System.in);
		
		System.out.println(ConsoleColour.BLUE_BRIGHT);
		System.out.println("***************************************************");
		System.out.println("* GMIT - Dept. Computer Science & Applied Physics *");
		System.out.println("*                                                 *");
		System.out.println("*             Text Simplifier V0.1                *");
		System.out.println("*       (AKA Orwellian Language Compliance)       *");		
		System.out.println("*                                                 *");
		System.out.println("***************************************************");

		
		Build database = new Build();
		
		database.start();
		
Build.getMap().forEach((key, value) -> System.out.println("This is the map: " + key + ":" + value));		
		System.out.print("Enter Text>");	
		
		userInput = scanner.nextLine().toString(); //ORANGE
		
		System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);		
		System.out.println(ConsoleColour.RESET);
		Runner run = new Runner();

		database.getGoogleEquivalent(userInput);
	}
}
