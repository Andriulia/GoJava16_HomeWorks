package Main.Java;

import java.util.Scanner;

public class Counts {

    static void start() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(menu);
            choice();
        } while (sc.hasNext());
    }

    static String menu = "Make your choice:\n1: NumberColumn\n2: DrawRectangle" +
            "\n3: DrawSquare\n4: Max\n5: RecurNumberColumn\n6: RecurRectangle\n\nQ: Exit";

    static void newLine() {
        System.out.println("Input x:");
        int x = isPositiveInt();
        for (int i = 0; i < x; i++) {
            System.out.println(i + 1);
        }
        goOn();
    }

    static void draw(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("+");
            }
            System.out.println();
        }
        goOn();
    }

    static void drawRectangle() {
        System.out.println("Input width:");
        int a = isPositiveInt();
        System.out.println("Input height:");
        int b = isPositiveInt();
        draw(a, b);
    }

    static void drawSquare() {
        System.out.println("Input width:");
        int a = isPositiveInt();
        draw(a, a);
    }

    static float getMax(float a, float b) {
        return a == b ? a : Math.max(a, b);
    }

    static int getMax(int a, int b) {
        return a == b ? a : Math.max(a, b);
    }

    static void showNumMax() {
        System.out.println("Input a:");
        float a = isFloat();
        System.out.println("Input b:");
        float b = isFloat();
        if (a - (int) a == 0 && b - (int) b == 0) {
            int c = (int) a;
            int d = (int) b;
            System.out.println(getMax(c, d));
        } else {
            System.out.println(getMax(a, b));
        }
        goOn();
    }

    static String newRecurLine(int x) {
        return x == 1 ? "1" : newRecurLine(x - 1) + "\n" + x;
    }

    static void showNewRecurLine() {
        System.out.println("Input a:");
        int a = isPositiveInt();
        System.out.println(newRecurLine(a));
        goOn();
    }

    static String newString(int a) {
        return a == 1 ? "+" : newString(a - 1) + "+";
    }

    static String recurRectangle(int a, int b) {
        return b == 1 ? newString(a) : newString(a) + "\n" + recurRectangle(a, b - 1);
    }

    static void showRecurRectangle() {
        System.out.println("Input width:");
        int a = isPositiveInt();
        System.out.println("Input height:");
        int b = isPositiveInt();

        System.out.println(recurRectangle(a, b));
        goOn();
    }

    static boolean floatVerifier(String s) {
        try {
            Float.parseFloat(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    static float isFloat() {
        Scanner sc = new Scanner(System.in);
        String s;
        while (true) {
            s = sc.nextLine();
            if (s.equalsIgnoreCase("q") || s.equalsIgnoreCase("quit")) {
                System.exit(222);
            } else if (!floatVerifier(s.trim()) || s.trim().isEmpty()) {
                System.out.println("Re-input: ");
            } else {
                return Float.parseFloat(s.trim().split(" ")[0]);
            }
        }
    }

    private static boolean intVerifier(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }

    static int isPositiveInt() {
        Scanner sc = new Scanner(System.in);
        String s;
        while (true) {
            s = sc.nextLine();
            if (s.equalsIgnoreCase("q") || s.equalsIgnoreCase("quit")) {
                System.exit(222);
            } else if (intVerifier(s.trim()) || s.trim().isEmpty() || Integer.parseInt(s.trim().split(" ")[0]) <= 0) {
                System.out.println("Re-enter: ");
            } else {
                return Integer.parseInt(s.trim().split(" ")[0]);
            }
        }
    }

    static void goOn() {
        System.out.println("\nContinue?\nY: Yes\nAnyOtherKey: Exit");
        Scanner sc = new Scanner(System.in);
        String i = sc.next();
        switch (i) {
            case "Y":
            case "y": {
                System.out.println(menu);
                choice();
            }
            default:
                System.out.println("Bye!");
                System.exit(0);
        }
    }

    static void choice() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String i = sc.next();
            switch (i) {
                case "1":
                    newLine();
                    break;
                case "2":
                    drawRectangle();
                    break;
                case "3":
                    drawSquare();
                    break;
                case "4":
                    showNumMax();
                    break;
                case "5":
                    showNewRecurLine();
                    break;
                case "6":
                    showRecurRectangle();
                    break;
                case "Q":
                case "q":
                    System.out.println("Bye!");
                    System.exit(0);
                default:
                    System.out.println("'_'");
            }
        }
    }
}
