package Task2;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CountDirectory implements Runnable {

    private String pathDirectory;

    StringBuilder builder = new StringBuilder();
    private SimpleDateFormat dateForm = new SimpleDateFormat("HH:mm:ss dd MMMM yyyy");

    public CountDirectory(String pathDirectory) {
        this.pathDirectory = pathDirectory;

        String toWrite = (builder.append("Date: ").append(dateForm.format(new Date().getTime()).toString()).
                append(System.getProperty("line.separator")).
                append("Files: ").append(countFiles(pathDirectory)).append(System.getProperty("line.separator")).
                append("Directories: ").append(countDirectory(pathDirectory))).append(System.getProperty("line.separator"))
                .append(System.getProperty("line.separator")).toString();

        try {
            WriteFile writeFile = new WriteFile("C:\\JAVA\\file.txt",toWrite);
            System.out.println(toWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int countDirectory(String pathDirectory){
        File file = new File(pathDirectory);
        int countDirectory = 0;
            for (File d : file.listFiles()) {
                if(d.isDirectory()){
                    countDirectory++;
                    countDirectory+=countDirectory(d.getPath());
                }
            }
        return countDirectory;
    }

    private int countFiles(String pathDirectory){
        File files = new File(pathDirectory);
        int countFiles = 0;
            for (File f : files.listFiles()) {
                if (f.isFile()) {
                    countFiles++;
                }
                if (f.isDirectory()) {
                    countFiles += countFiles(f.getPath());
                }
            }
        return countFiles;
    }

    @Override
    public void run() {
        new CountDirectory(pathDirectory);
    }
}
