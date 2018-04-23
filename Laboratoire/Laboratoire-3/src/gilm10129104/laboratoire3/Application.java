package gilm10129104.laboratoire3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by gilm101291 on 2018-02-13.
 */
public class Application {

    public static void main(String[] args) throws FileNotFoundException {

        int step = 10;
        int k = 0;
        Etudiant[] tabEtu = new Etudiant[step];
        Scanner scanner;

        if (args.length == 0){
            scanner = new Scanner(System.in);
        } else {
            scanner = new Scanner(new FileInputStream(args[0]));
        }
        while (scanner.hasNext()) {
            if (tabEtu.length == k)
                tabEtu = Arrays.copyOf(tabEtu, k + step);

            String enr = scanner.next();
            tabEtu[k++] = Etudiant.parseEtu(enr);
        }
        trierEtu(tabEtu);
        for (Etudiant c : tabEtu) {
            System.out.println(c);
        }
    }

    public static void trierEtu(Etudiant[] tabEtu) {
        Etudiant temp;
        for (int i = 0; i < tabEtu.length; i++) {
            for (int j = 0; j < tabEtu.length - 1 - i; j++) {
                if(tabEtu[j]==null || tabEtu[j+1]==null) continue;
                if (tabEtu[j].getAge() > tabEtu[j + 1].getAge()) {
                    temp = tabEtu[j];
                    tabEtu[j] = tabEtu[j + 1];
                    tabEtu[j + 1] = temp;
                }
            }
        }
    }
}
