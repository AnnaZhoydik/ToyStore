

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileHandler {
    public static void clear(String nameFile){

        try {
            Path currentRelativePath = Paths.get("");
            String absoluteProjectPath = currentRelativePath.toAbsolutePath().toString() + "\\" + nameFile;
            Files.writeString(Path.of(absoluteProjectPath), "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void appendInFile(String nameFile, String string){
        try {
            Path currentRelativePath = Paths.get("");
            String absoluteProjectPath = currentRelativePath.toAbsolutePath().toString() + "\\" + nameFile;
            Files.writeString(Path.of(absoluteProjectPath), string, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
