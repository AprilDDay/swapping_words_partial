package ie.gmit.dip;

import java.util.*;
import java.io.*;

public class Database extends GoogleWords{

	private Set<String> set = new HashSet<>();
	public Database(String in) {
		super(in);
		// TODO Auto-generated constructor stub
	}

	Map<String, String> map = new HashMap<>();
	
	public Set<String> createSet(){
		try {
			set.add(SomeFiles.googleWordFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
	}

		
	
	public Map<String,String> initialise() throws Exception {

		set.add(SomeFiles.googleWordFile);
		boolean fill=false;
		
		String[] words;
		String googleWord;
		
		GoogleWords googleWords;

		String line = new String();
		BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(SomeFiles.mobyThesaurus2File))));
		
		String word = new String();
		googleWord = null;

		while ((line = br2.readLine()) !=null) {
			words = line.split(",");
			for (String w: words) {
				if(((Set<String>) set).contains(w)){
					fill =  true;
					googleWord = w;
					//exec(fill);
					addAll(words, googleWord);
					 if((boolean)((Set<String>) set).contains(w)) {
						 googleWord = w;
						 map.put(word, googleWord);
					 }
						break;
			}
			}
		}
		return map;
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

	
}
