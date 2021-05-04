package ie.gmit.sw;
import java.io.*;
import java.util.*;

public class Parser  {
	public HashMap<String, String> map = new HashMap<String, String>();// hash map as a map for faster time complexity
	private Collection<String> google = new HashSet<String>();// hashset to compare google words with each line of the thesaurus
	
	public void parseGoogle(String file) throws IOException{ 
		BufferedReader br = new BufferedReader(new InputStreamReader((new FileInputStream(file))));	
		String word;
		while ((word = br.readLine()) != null) {	
				google.add(word);// adding google words to my collection of HashSet
				map.put(word, word);// mapping each google word with itself 
		}//end while
		br.close(); // close the file
	}//end of parseGoogle
	
	public void parseThesaurus(String file) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((new FileInputStream(file))));
		String line, word;
			
			while((line = br.readLine()) != null) {
				String[] words = line.split(","); 
				word = findGoogleWord(words); // find my google word if exists in my thesaurus line
				if(word != null) { // if my returned word is not null, 
					for(int i = 0; i < words.length; i++) { // add each word,
						map.put(words[i], word);// to my map with its google original value
					}//end for
				}//end if				
			}// end while		
			br.close(); // close the file 		
	}// end of parseThesaurus
	
	private String findGoogleWord(String[] words) {
		String googleWord = null; // originally set to null
		for(String word : words) { // loop over each word of array
			if(google.contains(word)) { // if contains my google word
				googleWord = word; 
			}//end if
		}//end for
		return googleWord; // return my word
	}//end findGoogleWord
}// end class