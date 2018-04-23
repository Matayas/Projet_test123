package gilm10129104.laboratoire1.Q1;

/**
 * Created by gilm101291 on 2018-01-30.
 */


public class Application {

    public static void main(String[] args) {
        String[] array = args;

        String temp;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {

                if (array[j].compareTo(array[j + 1]) > 0) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }

    }
}











