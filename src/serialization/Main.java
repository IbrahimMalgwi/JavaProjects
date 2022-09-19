package serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person"))){
            Person person = new Person("Judith", 4);
            out.writeObject(person);

        } catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
