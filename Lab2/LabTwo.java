import java.io.File;  
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

class LabTwo {
	
	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the source filename: ");
		String input = reader.nextLine();
		System.out.println(input);
		System.out.println("Enter the output filename: ");
		String output = reader.nextLine();
		System.out.println(output);
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