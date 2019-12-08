import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
        int idx = 0;
        String [][] alertLogs = new String[numLogs][];
        System.out.println(numLogs);
        if(dir.isDirectory()) {
            for(File file : dir.listFiles()) {
                if(file.isFile()) {
                    try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
                        int count = 0;
                        while ((line = fileReader.readLine()) != null) {
                            if(count > 0) {
                                alertLogs[idx] = line.split(SPLITTER);
                                for (int i = 0; i < alertLogs[idx].length; i++)
                                    System.out.print(alertLogs[idx][i] + " + ");
                                System.out.println();
                            }
                            count++;
                        }
                        idx++;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("=================================");
        for(int i = 0; i < alertLogs.length; i++) {
            for (int k = 0; k < alertLogs[i].length; k++) {
                System.out.print(alertLogs[i][k] + " + ");
            }
            System.out.println();
        }
    }
}