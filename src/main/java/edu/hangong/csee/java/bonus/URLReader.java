package edu.hangong.csee.java.bonus;

import java.io.InputStream;
import java.io.FileWriter;


import java.net. *;
import java.io. *;

public class URLReader {
	 public static void reader(String inputPath,String outputPath) throws Exception {

	        URL oracle = new URL(inputPath);
	        BufferedReader in = new BufferedReader(
	        new InputStreamReader(oracle.openStream()));
	        FileWriter fw = new FileWriter(outputPath+"/"+"JC.html");
	        
	        URLWriter apply=new URLWriter();
	        apply.writer(fw, in);
	        
	        fw.close();
	        
	        in.close();
	        
	    }
}
