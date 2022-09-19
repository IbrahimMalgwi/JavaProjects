package fileIO;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOutputStreamSample {
    public static void main(String[] args) {
        try (var fos = new FileOutputStream("C:\\Users\\user\\Desktop\\test.txt ");
            var writer = new PrintWriter(fos)) {
            writer.println("We are Unicorns!!!");
        } catch (IOException exception){
            System.out.println(exception.getLocalizedMessage());

        }
    }
}
