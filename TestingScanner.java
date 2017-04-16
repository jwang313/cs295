import java.io.File;  
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

class TestingScanner {
	
	public static void main(String[] args)
	{
		
	    String input = "testfile1.txt";
	    String output = "new.txt";
	    String line = null;
	    	try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(input);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            FileWriter fileWriter =
                new FileWriter(output);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

          

            while((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
            }   
            bufferedWriter.close();
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                output + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + output + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
	}
}