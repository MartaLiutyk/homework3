import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WorkWithFiles {
    public static String getInfoFromConsole() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Which  information would you like to add to  the file? ");
        String information = br.readLine();
        return information;
    }

    public static void putDataIntoFile(String information) throws IOException {
        Path file = Paths.get("C:/Users/melod/hw3/helloworld/filework");
        Files.write(file, information.getBytes());
    }

    public static void main(String[] args) throws IOException {
        String data = getInfoFromConsole();
        putDataIntoFile(data);
    }


}
