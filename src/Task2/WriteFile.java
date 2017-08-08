package Task2;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    private String fileNameAndPath;
    private String toWrite;

    public WriteFile(String fileNameAndPath, String toWrite) throws IOException {
        this.fileNameAndPath = fileNameAndPath;
        this.toWrite = toWrite;
        writeFile();
    }

    private void writeFile(){
        try(BufferedWriter newFile = new BufferedWriter(new FileWriter(this.fileNameAndPath,true))) {
            newFile.write(this.toWrite);
            newFile.flush();
            newFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
