/**
 * 
 */

/**
 * @author MH
 *
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.poi.*;

public class AlertLog {
    private static final int SEVERITY = 0;
    private static final int AA = 1;
    private static final int BB = 2;
    private static final int CC = 3;

    private static final String SPLITTER = ",";

    public static void main(String[] args) {
        String alertLogsPath = args[0];
        String iMLListFile = args[1];

        String line = "";

        File dir = new File(alertLogsPath);

        int numLogs = dir.listFiles().length;
        ArrayList <ArrayList <String>> alertLogs = new ArrayList<ArrayList<String>>(); 
        System.out.println(numLogs);
        try {
        	if(dir.isDirectory()) {
	            for(File file : dir.listFiles()) {
	                if(file.isFile()) {
	                    BufferedReader fileReader = new BufferedReader(new FileReader(file));
                        while ((line = fileReader.readLine()) != null) {
                            //skip the header (first) line
                            if(!(line.contains("#"))) {
                            	String temp[] = line.split(SPLITTER);
                            	ArrayList <String> tempAL = new ArrayList<String>();
                                Collections.addAll(tempAL, temp);
                                alertLogs.add(tempAL);
                            }
                        }
                        fileReader.close();
	                }
	            }
	        }
        }
        catch(IOException e) {
        	e.printStackTrace();
        }
    }
}
