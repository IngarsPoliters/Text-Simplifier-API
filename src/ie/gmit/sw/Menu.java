package ie.gmit.sw;

import java.io.File;
import java.util.*;

public class Menu {
	private boolean keepRunning = true;
	//private Map<String, String> map = new TreeMap<>();
	private Parser p = new Parser();
	
	public void startParse() throws Exception {	
		File go = new File("./google-1000.txt");// File objects
		File mo = new File("./MobyThesaurus2.txt");
		String pathG = go.getAbsolutePath();// Absolute path of file 
		String pathM = mo.getAbsolutePath();
		p.parseGoogle(pathG); // sending my file path to my parse methods in Parser class
		p.parseThesaurus(pathM);	
		Menu(); // after parsing is done, go to Menu method
	}// end of start
	
	public void Menu() throws Exception {
		Scanner s = new Scanner(System.in);
		String option;
		
		showMenuOptions();
		do{
			option = s.nextLine(); // blocking method
			if (option.equalsIgnoreCase("Quit")) {keepRunning = false;}// if Quit entered, exit loop 
			else{
				String sentence = reduce(option);// sending sentence to be processed and returned with changed sentence
				System.out.println(sentence); 
				showMenuOptions();// re-enter text until "Quit" is entered
			}// end else
		}while (keepRunning);
		s.close(); // close the scanner after finish
	}// end Menu()
	
	public String reduce(String text) throws Exception{
		String[] words = text.split(" "); // splitting text into array list
		StringBuilder sb = new StringBuilder();
		Collection<String> keys = p.map.keySet(); // recover a collection of my map key set
		for (String word : words) { // loop over each word in array 
			if(keys.contains(word)) { // if word matches map key
				word = p.map.get(word); // then replace word with map value
			}
			sb.append(word + " ");// change array back to line of text
		}
		return sb.toString(); // return my changed sentence 
	}
	
	public void showMenuOptions() {
		System.out.print("Enter Text>");
		System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
	}// end showMenuOption
}// end Menu class
