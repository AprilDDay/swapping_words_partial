package ie.gmit.dip;

import java.util.*;

public class TheSet extends FillingWords{
	
	private Set<String> set = new HashSet<>(); 

	private String in = SomeFiles.googleWordFile;
	
	public TheSet(String in) {
		super(in);
		// TODO Auto-generated constructor stub
	}

	public Set<String> fillTheSet(String in) {
		try {
			super.fillSet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}
		
	
}
