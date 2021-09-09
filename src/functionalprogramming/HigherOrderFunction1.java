package functionalprogramming;

/* Raj Kumar Boddupally created on 8/15/2021 inside the package - functionalprogramming */

import java.io.File;
import java.io.FileFilter;

public class HigherOrderFunction1 {


    public static void main(String[] args) {

        //Before Java 8 - higher order function. Anonymous inner class
        File[] txtfiles = new File("C:\\Users\\adhvi\\Downloads").listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getPath().endsWith("txt");
            }
        });

        //Java 8 Lambda - Statement with Lambda;
        File[] txtfiles1 = new File("C:\\Users\\adhvi\\Downloads").
                listFiles((dir, name) -> {
                    return name.endsWith("txt") && dir.canWrite();
                });

        //Java 8 Lambda simplified - Expression Lambda
        File[] txtfiles2 = new File("C:\\Users\\adhvi\\Downloads").
                listFiles((dir, name) ->
                        name.endsWith("txt") && dir.canWrite());

        assert txtfiles1 != null;
        for (File file : txtfiles1) {
            System.out.println(file.getName());
        }
    }
}
