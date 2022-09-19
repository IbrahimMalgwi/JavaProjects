package fileIO;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InaccessibleObjectException;

public class FileWriterSample {
    public static void main(String[] args) {
        try (FileWriter fileWriter = new FileWriter("C:\\Users\\user\\Desktop\\testx.txt")){
            fileWriter.write("Just do it");
        } catch (IOException exception){
            exception.printStackTrace();
        }

    }
}
