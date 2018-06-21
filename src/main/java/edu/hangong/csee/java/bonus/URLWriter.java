package edu.hangong.csee.java.bonus;

import java.net. *;
import java.io. *;

public class URLWriter {

	void writer( FileWriter fw,BufferedReader in){

		String inputLine;
		try {
			while ((inputLine = in.readLine()) != null) {

				fw.write(inputLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
