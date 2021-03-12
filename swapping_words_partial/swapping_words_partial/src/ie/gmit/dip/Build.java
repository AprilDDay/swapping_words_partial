package ie.gmit.dip;

import java.util.*;

public class Build {
	
	private static Set<String> set = new HashSet<>();
	private static Map<String, String> map = new HashMap<>();
	private static Map<String, String> map2 = new HashMap<>();
		
	private static Map<String, String> map3 = new HashMap<>();

	public Map<String, String> start(){
	
		Database database = new Database(SomeFiles.googleWordFile);
		try {
			
			map2 = (database.initialise());
			map2.forEach((key, value) -> System.out.println("This is map2: "+key+":"+value));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			map = database.putGoogleWords();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Map temp = new HashMap(map2);
		temp.keySet().removeAll(map.keySet());
		map.putAll(map2);
		
		return map;
	}
	
	public static Map<String, String> getMap() {
		map.forEach((key,value)-> System.out.println("This is the map: " + key + ":"+value));
		return map;
	}

	public static void setMap(Map<String, String> map) {
		Build.map = map;
		map.forEach((key,value)-> System.out.println("This is the map: " + key + ":"+value));
	}

	public String getGoogleEquivalent(String userInput) {

	Build database = new Build();
	String[] temps = userInput.split(" ");//this works
	String output = new String();
	for (int i=0; i<temps.length; i++) {
		if(database.start().containsKey(temps[i])) {	
			temps[i] = (database.start().get(temps[i]));
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

	
}