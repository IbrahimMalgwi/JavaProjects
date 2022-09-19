package fileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamSample {
    public static void main(String[] args) {
        String[] cars = {"Honda", "Toyota", "Peugeot", "Volvo"};

        try (var fos = new FileOutputStream("cars.txt");
             PrintStream printStream = new PrintStream(fos)){
            System.setOut(printStream);
            for (String car : cars) {
                System.out.println(car);

            }
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
