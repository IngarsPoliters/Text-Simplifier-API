package ie.gmit.sw;

public class Runner{
	public static void main(String[] args) throws Exception {
		System.out.println(ConsoleColour.BLUE_BRIGHT);
		System.out.println("***************************************************");
		System.out.println("* GMIT - Dept. Computer Science & Applied Physics *");
		System.out.println("*                                                 *");
		System.out.println("*             Text Simplifier V0.1                *");
		System.out.println("*       (AKA Orwellian Language Compliance)       *");		
		System.out.println("*                                                 *");
		System.out.println("***************************************************");
		
		Menu m = new Menu();// link between this class with the menu
		m.startParse();// calling startParse method from Menu class to parse google words with the moby thesaurus
		
		System.out.println(ConsoleColour.RESET);
	}
}