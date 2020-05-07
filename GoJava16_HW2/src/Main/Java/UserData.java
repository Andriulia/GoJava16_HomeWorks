package Main.Java;

import java.util.Scanner;

class UserData {
	static void data() {
		
		String input;
		do {
			System.out.println("Input name: ");
			input = inputVerifier();
		} while (input.isEmpty());
		String name = input;

		do {
			System.out.println("Input city: ");
			input = inputVerifier();
		} while (input.isEmpty());
		String city = input;

		int age;
		do {
			System.out.println("Input age: ");
			age = ageVerifier();
		} while (age == 0);

		do {
			System.out.println("Input hobby: ");
			input = inputVerifier();
		} while (input.isEmpty());
		String hobby = input;

		System.out.print("\n----------------------------------\n" +
				"Вариант 1 (табличный):\n" +
				"Имя: " + capitalLetter(name) + "\n" +
				"Город: " + capitalLetter(city) + "\n" +
				"Возраст: " + age + "\n" +
				"Хобби: " + hobby + "\n" +
				"----------------------------------\n" +
				"Вариант 2 (текстовый):\n" +
				"Человек по имени " + capitalLetter(name) + " живет в городе " + capitalLetter(city) + ".\n" +
				"Этому человеку " + age + " лет и любит он заниматься " + hobby + ".\n" +
				"----------------------------------\n" +
				"Вариант 3 (иной):\n" +
				capitalLetter(	name) + " - имя\n" +
				capitalLetter(city) + " - город\n" +
				age + " - возраст\n" +
				hobby + " - хобби\n" +
				"----------------------------------");
	}

	private static String inputVerifier() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		if (s.equalsIgnoreCase("q") || s.equalsIgnoreCase("quit")) {
			System.exit(111);
		}
		return s.trim();
	}

	private static int ageVerifier() {
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

	private static String capitalLetter (String s){
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}
}
