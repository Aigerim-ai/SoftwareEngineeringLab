package kz.edu.nu.cs.cliexample;


import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * 
 */
public class App {
    public static void main(String[] args) {
//
       //2. parse parse methods of CommandLineParser are used to parse the command line arguments
        CommandLineParser parser = new DefaultParser(); //default parser
        
        //1. create options
        Options options = new Options(); //option object is created
        options.addOption("help", false, "print this help message"); //addhelp option
        options.addOption("s", true, "input string"); //addOption method has 3 parapms
        //the first is java.lang.String - option , 2nd-boolean that specifies whether the option requires an argument or not. 
        //disciption of an option
        CommandLine cmd;
        
        
        try {
            cmd = parser.parse(options, args);//used to parse arguments
            
            if (cmd.hasOption("help")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("App", options);
                System.exit(0);
            }
            
            if (cmd.hasOption("s")) {
                String s = cmd.getOptionValue("s"); //	
              //  Retrieve the first argument, if any, of this option. char opt
                System.out.println(wordcount(s));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        
        
        
        
       
    }
    
    

    public static int wordcount(String s) {
    	if (s == null || s.isEmpty()) 
    	{ 
    		return 0; 
    	}
    	
    	String[] counter = s.split("\\s+"); 
    	return counter.length;
    	
    	
    }
    
}
