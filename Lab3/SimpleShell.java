import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
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
        String currentDirectory = System.getProperty("user.dir");
        while (true){
            System.out.print(">>");
            commandLine = console.readLine();
            StringTokenizer st = new StringTokenizer(commandLine);
            ArrayList<String> input = new ArrayList<String>();
            while (st.hasMoreTokens()){
                input.add(st.nextToken());
            }
           
            try {
                
            ProcessBuilder pb = new ProcessBuilder(input);
            pb = pb.directory(new File(currentDirectory));
            
            if (input.get(0).equals("cd"))
            {
                currentDirectory = currentDirectory + "/" + input.get(1);
                
            }
            else
            {
                Process p1 = pb.start();
                System.out.println("Echo Output:\n" + output(p1.getInputStream()));
            }
            }
            catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
            }
            finally {
                continue;
            }
            
        }
       
// we break out with <control><C> while (true) { // read what the user entered System.out.print("jsh>"); commandLine = console.readLine();
// if the user entered a return, just loop again if (commandLine.equals("")) continue;
/** The steps are: (1) parse the input to obtain the command and any parameters (2) create a ProcessBuilder object (3) start the process (4) obtain the output stream (5) output the contents returned by the command */
    }
}  