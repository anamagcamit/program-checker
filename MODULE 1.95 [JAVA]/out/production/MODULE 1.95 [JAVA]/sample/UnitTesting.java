package sample;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class UnitTesting {

    @Test
    void GetFilesTest() {
        Controller cont = new Controller();
        cont.FolderDirectories();
        assertTrue(cont.foldercounter!=0);
    }

    @Test
    void GetFilesInFolder() throws IOException{
        Controller cont = new Controller();
        cont.GetFilesPerFolder();
        assertTrue(cont.folderdirectories.length!=0);
    }

    @Test
    void CompareFiles() throws IOException {
        Controller cont = new Controller();
        cont.CompareFiles();
        assertTrue(cont.matrix.length!=0);
    }

}
