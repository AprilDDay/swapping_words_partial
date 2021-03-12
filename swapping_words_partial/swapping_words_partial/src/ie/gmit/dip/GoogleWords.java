package ie.gmit.dip;

import java.util.*;

public class GoogleWords extends FillingWords {

	private static String in = SomeFiles.googleWordFile; 
	
	private Map<String, String> map = new HashMap<>();
		
	public GoogleWords(String in) {
		super(in);
		
	}


	/**
	 * Puts Google words matching to Google words in the database
	 * 
	 */
	//public void putGoogleWords() throws Exception{
	public Map<String, String> putGoogleWords() throws Exception {

		super.fillDataBase(SomeFiles.googleWordFile);
		return map;
	}
	
	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Map<String, String> getMap() {
		return this.map;
	}
	
	public String getIn() {
		return in;
	}


	public void setIn(String in) {
		this.in = in;
	}
	
	
	public Set<String> fillTheSet(String in) {
		Set<String> set = new HashSet<>();
		try {
			super.fillSet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
	}

	
}
