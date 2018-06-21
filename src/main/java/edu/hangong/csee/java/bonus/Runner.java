package edu.hangong.csee.java.bonus;


import org.apache.commons.cli.CommandLine;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class Runner {
	
	static String inputPath,outputPath;
	boolean verbose;
	boolean help;

	public static void main(String[] args) {

		Runner myRunner = new Runner();
		myRunner.run(args);
		
		String link= inputPath;
		String path= outputPath;

		
		try {
			URLReader.reader(link,path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				 
		

	}

	private void run(String[] args) {
		Options options = createOptions();
		
		if(parseOptions(options, args)){
			if (help){
				printHelp(options);
				return;
			}
			
			// path is required (necessary) data so no need to have a branch.
			System.out.println("You provided \"" + inputPath + "\" as the value of the option u");
			System.out.println("You provided \"" + outputPath + "\" as the value of the option d");		
			
			// TODO show the number of files in the path
			
			if(verbose) {
				
				// TODO list all files in the path
				
				System.out.println("Your program is terminated. (This message is shown because you turned on -v option!");
			}
		}
	}

	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);

			inputPath = cmd.getOptionValue("u");
			outputPath = cmd.getOptionValue("d");
			verbose = cmd.hasOption("v");
			help = cmd.hasOption("h");

		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}

	// Definition Stage
	private Options createOptions() {
		Options options = new Options();

		// add options by using OptionBuilder
		options.addOption(Option.builder("u").longOpt("path")
				.desc("URL and a directory path where the web pages (html files) are saved into your HDD")
				.hasArg()
				.argName("URL path")
				.required()
				.build());
		
		// add options by using OptionBuilder
		options.addOption(Option.builder("d").longOpt("path")
				.desc("web page files saved into the directory path which is one of inputs")
				.hasArg()
				.argName("Directory path")
				.required()
				.build());

		// add options by using OptionBuilder
		options.addOption(Option.builder("v").longOpt("verbose")
				.desc("Display detailed messages!")
				//.hasArg()     // this option is intended not to have an option value but just an option
				.argName("verbose option")
				//.required() // this is an optional option. So disabled required().
				.build());
		
		// add options by using OptionBuilder
		options.addOption(Option.builder("h").longOpt("help")
		        .desc("Help")
		        .build());

		return options;
	}
	
	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "CLI test program";
		String footer ="\nPlease report issues at https://github.com/lifove/CLIExample/issues";
		formatter.printHelp("CLIExample", header, options, footer, true);
	}

}