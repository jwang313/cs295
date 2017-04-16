import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SimpleShell {
    
    private static String output(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + System.getProperty("line.separator"));
            }
        } finally {
            br.close();
        }
        return sb.toString();
    }

    public static void main(String[] args) throws java.io.IOException {
        String commandLine; 
        BufferedReader console = new BufferedReader (new InputStreamReader(System.in));
        
        ProcessBuilder pb = new ProcessBuilder("ls");
        Process p1 = pb.start();
        System.out.println("Echo Output:\n" + output(p1.getInputStream()));
// we break out with <control><C> while (true) { // read what the user entered System.out.print("jsh>"); commandLine = console.readLine();
// if the user entered a return, just loop again if (commandLine.equals("")) continue;
/** The steps are: (1) parse the input to obtain the command and any parameters (2) create a ProcessBuilder object (3) start the process (4) obtain the output stream (5) output the contents returned by the command */
    }
}  