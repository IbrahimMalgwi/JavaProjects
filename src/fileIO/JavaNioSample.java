package fileIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;

public class JavaNioSample {
    public static void main(String[] args) throws IOException {
        // java.nio classes Paths and Files
        // and interfaces Path and Directories

        Path path = Paths .get("C:\\Users\\user\\Desktop");
        System.out.println("is a directory->" + Files.isDirectory(path));
        System.out.println("is a directory->" + Files.isHidden(path));

        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);

        for (Path path1 : directoryStream){
            if (Files.isDirectory(path1)) {
                FileAttribute<String> f = new FileAttribute<String>() {
                    @Override
                    public String name() {
                        return "test2.txt";
                    }

                    @Override
                    public String value() {
                        return "6";
                    }
                };
                Files.createFile(path1, f);
            }
        }

    }
}
