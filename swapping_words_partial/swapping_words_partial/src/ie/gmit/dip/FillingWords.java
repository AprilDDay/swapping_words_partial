package ie.gmit.dip;

import java.io.*;
import java.util.*;

public abstract class FillingWords {

		
		private Map<String, String> map = new HashMap<>();
		protected Set<String> set = new HashSet<>();
				
		//ANY VERSION
		protected String in; //= SomeFiles.googleWordFile;
		
		public FillingWords(String in) {
			super();
			this.in = in;
			this.map = map;
			this.set = set;
		}
		
		protected String in() {
			return in;
		}

		public Set<String> fillSet() throws Exception {
					
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(in))));
			String line = new String();
			//System.out.println(line);
			while ((line = br.readLine()) != null) {
				set.add(line);
				//System.out.println("This is the set: " + set);
			}		
			br.close();
			return set;
		}
		
		/**Method to fill map
		 * @param googlewordfile 
		 * 
		 * 
		 * @throws Exception
		 */
		public void fillDataBase(String googlewordfile) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(in))));
			String word = new String();
			while ((word = br.readLine()) != null) {
				map.put(word, word); //for Google 1000 words to map to themselves
				//System.out.print("This is the map: " + map);
			}
			br.close();
		}

	}
	
