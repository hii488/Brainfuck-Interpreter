package me.laurence.brainfuck;

import java.io.BufferedReader;
import java.io.FileReader;

public class BFI {

	public static void main(String[] args) {
		String s = getFilename(args);
		String f = getBrainfuck(s);
		
		new Interpreter().interpret(f);
	}
	
	public static String getFilename(String[] args) {
		if(args.length != 1) {
			System.err.println("Usage: java -jar BrainFuckInterpreter <filename>");
			System.exit(1);
		}
		
		return args[0];
	}
	
	public static String getBrainfuck(String s) {
		String brainfuck = "", line;
		
		try {
			FileReader reader = new FileReader(s);
			BufferedReader breader = new BufferedReader(reader);
			
			while((line = breader.readLine()) != null) {
				brainfuck += line;
			}
			
			breader.close();
			reader.close();
		}
		catch(Exception e) {
			System.err.println("\nError loading file \"" + s + "\"\n");
			
			e.printStackTrace();
			System.exit(1);
		}
		
		return brainfuck;
	}

}