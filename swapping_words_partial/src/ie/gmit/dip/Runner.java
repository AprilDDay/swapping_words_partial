package ie.gmit.dip;

	import java.util.*;
	import java.util.ArrayList;
	import java.io.*;
	import java.util.Arrays.*;


	//for making things plural??? singular??? http://www.java2s.com/Tutorial/Java/0040__Data-Type/Transformswordstosingularpluralhumanizedhumanreadableunderscorecamelcaseorordinalform.htm

	public class Runner {

		private static Scanner scanner;
		private static String userInput = new String();
		
		private static boolean fill=false;
		
		private String[] words;
		private String googleWord;
		
		private Map<String, String> map = new HashMap<>();
		private Set<String> set = new HashSet<>();
		
		private static final String googleWordFile = "./google-1000.txt";
		private static final String mobyThesaurus2File = "./MobyThesaurus2.txt";
			
		public void createSet() throws Exception {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(googleWordFile))));
			String line = new String();
			
			while ((line = br.readLine()) != null) {
				set.add(line);
				//System.out.println("This is the RUNNER set: "+set);
			}		
			br.close();
		}
		
		public void initialise() throws Exception {
		
			String line = new String();
			//String line2 = new String();
			BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(mobyThesaurus2File))));
			
			String word = new String();
			googleWord = null;

	//SOMETHING IS WRONG WITH HOW YOU ARE ADDING THE MOBY THESAURUS WORDS TO THE MAP
			while ((line = br2.readLine()) !=null) {
				words = line.split(",");
				for (String w: words) {
					if(set.contains(w)){
						fill =  true;
						googleWord = w;
						//exec(fill);
						addAll(words, googleWord);
						 if(set.contains(w)) {
							 googleWord = w;
							 map.put(word, googleWord);
						 }
							break;
				}
				}
			}
		}		

		public void putGoogleWords() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(googleWordFile))));
		String word = new String();
		while ((word = br.readLine()) != null) {
			map.put(word, word); //for Google 1000 words to map to themselves
			//System.out.print("This is the map: " + map);
		}
		br.close();
		}

		
	/*		public void exec(boolean fill) {
				if(fill==true) {
					addAll(words, googleWord);						
					}			
			}*/
		
			private void addAll(String[] words, String googleWord) {
				for(String word: words) {
					map.put(word,googleWord);	
					}
			}
			
			public String getGoogleEquivalent(String userInput) {

				String[] temps = userInput.split(" ");//this works
				String output = new String();
				for (int i=0; i<temps.length; i++) {
					if(map.containsKey(temps[i])) {	
						temps[i] = map.get(temps[i]);
						System.out.println("This is temp: " + temps[i]);//confirmed swap was done
					}else {
						System.out.println("This won't swap: " + temps[i]);
						temps[i] = temps[i];
					}		
				}
				
				StringBuffer outNow = new StringBuffer();
				
				for (int i=0; i<temps.length; i++) {
					outNow.append(temps[i] + " ");			
				}

				System.out.print(outNow);
				return output;
			}
	
		public static void main(String[] args) throws Exception {
			
			scanner = new Scanner(System.in);
			
	//		System.out.println(ConsoleColour.BLUE_BRIGHT);
			System.out.println("***************************************************");
			System.out.println("* GMIT - Dept. Computer Science & Applied Physics *");
			System.out.println("*                                                 *");
			System.out.println("*             Text Simplifier V0.1                *");
			System.out.println("*       (AKA Orwellian Language Compliance)       *");		
			System.out.println("*                                                 *");
			System.out.println("***************************************************");

			Runner run = new Runner();
			run.createSet();
			run.initialise();
			run.putGoogleWords();
			System.out.print("Enter Text>");	
			
			userInput = scanner.nextLine().toString();
			
			run.getGoogleEquivalent(userInput);
			
//			System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);		
//			System.out.println(ConsoleColour.RESET);
		
		
	}
}