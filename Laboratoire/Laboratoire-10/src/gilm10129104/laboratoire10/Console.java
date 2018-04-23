package gilm10129104.laboratoire10;

import java.io.*;

public class Console {
    private static boolean initialized = false;
    private static Console instance = new Console();

    private static void initialize() {
        if (initialized) return;
        initialized = true;

        try {
            String outFile = System.getenv("output-file");
            if (outFile != null) {
                PrintStream out = System.out;
                OutputStream fos = new FileOutputStream(new File(outFile));
                OutputStream wrapper = new OutputStream() {
                    @Override
                    public void write(int b) throws IOException {
                        fos.write(b);
                        out.write(b);
                    }

                    @Override
                    public void close() throws IOException {
                        fos.close();
                        out.close();
                    }

                    @Override
                    public void flush() throws IOException {
                        fos.flush();
                        out.flush();
                    }
                };
                PrintStream ps = new PrintStream(wrapper);
                System.setOut(ps);
            }
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static Console getInstance() {
        return instance;
    }

    private Console() {
        initialize();
    }

    public void format(String format, Object... params) {
        System.out.format(format, params);
    }


    public void println(String s) {
        System.out.println(s);
    }

    public void println() {
        System.out.println();
    }

    public void print(String s) {
        System.out.print(s);
    }

    public void println(Object o) {
        System.out.println(o);
    }
}
