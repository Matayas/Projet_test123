package gilm10129104.laboratoire6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Clavier {
    private Scanner scanner;
    private static Clavier instance = new Clavier();

    public static Clavier getInstance() {
        return instance;
    }

    private Clavier() {
        try {
            String testFile = System.getenv("test-file");
            if (testFile != null) {
                InputStream fis = new FileInputStream(new File(testFile));
                System.setIn(fis);
            }
        } catch (FileNotFoundException ignored) {
            System.out.println("Fichier de test non trouvé");
        }
        scanner = new Scanner(System.in);
    }

    private String nextLineWithoutComments() {
        String line = scanner.nextLine();
        while (line.trim().startsWith("#") && scanner.hasNext()) {
            line = scanner.nextLine();
        }
        return line;
    }

    public String nextLine() {
        String line = nextLineWithoutComments();
        if (System.in instanceof FileInputStream) {
            System.out.println(line);
        }
        return line;
    }

    public boolean hasNext() {
        return scanner.hasNext();
    }
}
