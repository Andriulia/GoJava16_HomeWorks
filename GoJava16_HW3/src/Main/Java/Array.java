package Main.Java;

import java.util.Arrays;
import java.util.Scanner;

class Array {

    private static int[] array;

    //1
    private static int definedArraySize() {
        int size;
        while (true) {
            System.out.println("Size?");
            size = intVerifier();
            if (size > 0) {
                return size;
            }
        }
    }

    //2
    static void definedArray() {
        int size = definedArraySize();
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            if (size == 1) {
                System.out.println("Input " + size + " number: ");
            } else {
                System.out.println("Input " + size + " numbers: ");
            }
            array[i] = intVerifier();
            size--;
        }
        System.out.println("\nYour " + array.length + "-length array is:\n" + Arrays.toString(array));
    }

    //3
    static void minimal() {
        int minimal = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            if (minimal > array[i + 1]) {
                minimal = array[i + 1];
            }
        }
        System.out.println("Minimal: " + minimal);
    }

    //4
    static void maximal() {
        int maximal = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            if (maximal < array[i + 1]) {
                maximal = array[i + 1];
            }
        }
        System.out.println("Maximal: " + maximal);
    }

    //5
    static void timesOfFive() {
        int counter = 0;
        for (int i : array) {
            if (i == 5) {
                counter++;
            }
        }
        System.out.println("Times of ''Five'': " + counter);
    }

    //6
    static void sortedArray() {
        Arrays.sort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }


    //7
    static void maximalIterationsNumber() {
        System.out.println("Maximal iterations number: " + iterations()[0]);
    }

    //8
    static void minimalIterationsNumber() {
        System.out.println("Minimal iterations number: " + iterations()[1]);
    }

    //9
    static void undefinedArray() {
        String[] string, line;
        String input;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Input numbers: ");
            input = sc.nextLine();
            line = input.split(" ");
            input = "";
            for (String s : line) {
                if (intVerifier(s)) {
                    input += s + " ";
                }
            }
        } while (input.isEmpty());

        string = input.split(" ");
        array = new int[string.length];

        for (int i = 0; i < string.length; i++) {
            array[i] = Integer.parseInt(string[i]);
        }

        System.out.println("\nYour " + string.length + "-length array is:\n" + Arrays.toString(array));
    }

    private static int[] iterations() {
        int[] iteration = new int[2];
        int counter, most, rare;
        most = rare = 1;
        for (int i : array) {
            if (array.length > 1 && i == array[0]) {
                rare++;
            }
        }
        for (int i = 0; i < array.length - 1; i++) {
            counter = 0;
            for (int j : array) {
                if (array[i] == j) {
                    counter++;
                }
            }
            if (counter < rare) {
                rare = counter;
            }
            if (counter > most) {
                most = counter;
            }
        }
        iteration[0] = most;
        iteration[1] = rare;
        return iteration;
    }

    private static int intVerifier() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("q") || s.equalsIgnoreCase("quit")) {
                System.exit(222);
            } else if (!intVerifier(s.trim()) || s.trim().isEmpty()) {
                System.out.println("Re-enter: ");
            } else {
                return Integer.parseInt(s.trim().split(" ")[0]);
            }
        }

        /*try {
            return Integer.parseInt(s.split(" ")[0]);
        } catch (NumberFormatException nfe) {
            return 0;
        }*/

        /*Scanner sc = new Scanner(System.in);
        String s;
        int i;
        while (true) {
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                return i;
            } else {
                s = sc.nextLine();
                if (s.equals("q") || s.equals("Q") || s.equals("quit") || s.equals("Quit")) {
                    System.exit(111);
                }
            }
        }*/
    }

    private static boolean intVerifier(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
