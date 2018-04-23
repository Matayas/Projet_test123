package gilm10129104.laboratoire11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Clavier {
    private static Clavier instance = new Clavier();
    private static boolean initialized = false;
    private Scanner scanner;

    private static InputStream initialize() {
        if (initialized) return System.in;
        initialized = true;
        try {
            String testFile = System.getenv("test-file");
            if (testFile != null) {
                InputStream fis = new FileInputStream(new File(testFile));
                System.setIn(fis);
            }
        } catch (FileNotFoundException ignored) {
            Console.getInstance().println("Fichier de test non trouvé");
        }
        return System.in;
    }

    public static Clavier getInstance() {
        return instance;
    }

    public Clavier() {
        this.scanner = new Scanner(initialize());
    }

    private String nextLineWithoutComments() {
        String line = scanner.nextLine();
        while (line.trim().startsWith("#") && scanner.hasNext()) {
            line = scanner.nextLine();
        }
        return line;
    }

    public String nextLine() {
        try {
            String line = nextLineWithoutComments();
            if (System.in instanceof FileInputStream) {
                Console.getInstance().println(line);
            }
            return line;
        } catch (NoSuchElementException e) {
            if (System.in instanceof FileInputStream) {
                Console.getInstance().println("^D");
            }
            throw e;
        }
    }

    public String nextLineNotEmpty() {
        return nextLineNotEmpty(null);
    }

    public String nextLineNotEmpty(String message) {
        String line;
        do {
            if (message != null && !message.isEmpty()) {
                Console.getInstance().print(message);
            }
            line = nextLine().trim();
        } while (line.isEmpty());
        return line;
    }


    public String nextLineOrDefault(String ifEmpty) {
        String line = nextLine().trim();
        if (line.isEmpty()) line = ifEmpty;
        return line;
    }

    public boolean hasNext() {
        return scanner.hasNext();
    }


}
