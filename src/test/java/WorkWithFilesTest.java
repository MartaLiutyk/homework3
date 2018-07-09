import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class WorkWithFilesTest {
    @Test
    public void getInfoFromConsole() {
        String information = ".";
        assertNotNull(information);
    }

    @Test
    public void putDataIntoFile() throws IOException {
        Path file = Paths.get("C:/Users/melod/hw3/helloworld/filework");
        assertTrue(file.toFile().exists());
    }

}
