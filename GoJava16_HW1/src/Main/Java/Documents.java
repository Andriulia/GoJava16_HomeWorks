package Main.Java;

import java.util.Scanner;

class Documents {

    static void data() {

        String input;
        do {
            System.out.println("Input name: ");
            input = inputVerifier();
        } while (input.isEmpty());
        String name = input;

        do {
            System.out.println("Input surname: ");
            input = inputVerifier();
        } while (input.isEmpty());
        String surname = input;

        int age;
        do {
            System.out.println("Input age: ");
            age = ageVerifier();
        } while (age == 0);

        do {
            System.out.println("Input city of birth: ");
            input = inputVerifier();
        } while (input.isEmpty());
        String from = input;

        do {
            System.out.println("Input current city: ");
            input = inputVerifier();
        } while (input.isEmpty());
        String current = input;

        int g;
        String gender = null;
        System.out.println("Choose gender:");
        do {
            System.out.println("1 - Male\n2 - Female\n3 - Else");
            g = ageVerifier();
        } while (g == 0 || g > 3);
        if (g == 1) {
            gender = "Male";
        } else if (g == 2) {
            gender = "Male";
        } else {
            System.out.println("Auf Wiedersehen!");
            System.exit(333);
        }


        System.out.print("------------------------ PASSPORT ------------------------\n" +
                "\n" +
                "----------------------------------------------------------\n" +
                "\n" +
                "-----\n" +
                "\n" +
                "----- Person: " + capitalLetter(name) + " " + capitalLetter(surname) + "\n" +
                "\n" +
                "-----\n" +
                "\n" +
                "----- Gender: " + gender + ", age: " + age + "\n" +
                "\n" +
                "-----\n" +
                "\n" +
                "----- Location: from - " + capitalLetter(from) + ", current - " + capitalLetter(current) + "\n" +
                "\n" +
                "-----\n" +
                "\n" +
                "----------------------------------------------------------\n" +
                "\n" +
                "----------------------------------------------------------");
    }

    static String inputVerifier() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.equalsIgnoreCase("q") || s.equalsIgnoreCase("quit")) {
            System.exit(111);
        }
        return s.trim();
    }

    static int ageVerifier() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.trim().isEmpty()) {
            return 0;
        } else if (s.equalsIgnoreCase("q") || s.equalsIgnoreCase("quit")) {
            System.exit(222);
        }
        try {
            int i = Integer.parseInt(s.split(" ")[0]);
            if (i > 0 && i < 150)
            {
                return i;
            }
        } catch (NumberFormatException nfe) {
            return 0;
        }
        return 0;
    }

    static String capitalLetter (String s){
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

}