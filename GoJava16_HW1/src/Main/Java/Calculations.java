package Main.Java;

import java.util.Scanner;

class Calculations {

    static void count() {
        int a, b;
        do {
            System.out.println("Input first number: ");
            a = intVerifier();
        } while (a == 0);

        do {
            System.out.println("Input second number: ");
            b = intVerifier();
        } while (b == 0);

        System.out.println("\n" +
                "сумма " + (a + b) +
                "\n" +
                "\n" +
                "\n" +
                "умножение " + (a * b) +
                "\n" +
                "\n" +
                "\n" +
                "деление" + ((float) a / (float) b) +
                "\n" +
                "\n" +
                "\n" +
                "разница " + (a - b) +
                "\n" +
                "\n" +
                "\n" +
                "деление по модулю " + (a % b) +
                "\n" +
                "\n" +
                "\n" +
                "== " + (a == b) +
                "\n" +
                "\n" +
                "\n" +
                "< " + (a < b) +
                "\n" +
                "\n" +
                "\n" +
                "> " +  (a > b));
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

