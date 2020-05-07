package Main.Java.Car;

import java.util.ArrayList;
import java.util.Scanner;

public class Car {
    private final int manufacturingDate;

    private String instanceName;
    private String motorType;
    private int maxSpeedIfNew;
    private int accelerationTime;
    private int passengerCapacity;
    private int currentNumberOfPassengers;
    private int currentSpeed;
    private ArrayList<CarWheel> wheels = new ArrayList<>();
    private ArrayList<CarDoor> doors = new ArrayList<>();

    public Car(int manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public Car(String instanceName, int manufacturingDate, String motorType, int maxSpeedIfNew, int accelerationTime,
               int passengerCapacity, int currentNumberOfPassengers, int currentSpeed, int wheelsAmount) {
        this.instanceName = instanceName;
        this.manufacturingDate = manufacturingDate;
        this.motorType = motorType;
        this.maxSpeedIfNew = maxSpeedIfNew;
        this.accelerationTime = accelerationTime;
        this.passengerCapacity = passengerCapacity;
        this.currentNumberOfPassengers = currentNumberOfPassengers;
        this.currentSpeed = currentSpeed;
        for (int i = 0; i < wheelsAmount; i++) {
            this.wheels.add(new CarWheel());
        }
        for (int i = 0; i < 4; i++) {
            this.doors.add(new CarDoor());
        }
    }

    public void currentSpeedChange(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void putOnePassenger() {
        if (!(this.currentNumberOfPassengers == this.passengerCapacity)) {
            this.currentNumberOfPassengers++;
        }
    }

    public void dropOffOnePassenger() {
        if (!(this.currentNumberOfPassengers == 0)) {
            this.currentNumberOfPassengers--;
        }
    }

    public void dropOffAllPassengers() {
        this.currentNumberOfPassengers = 0;
    }

    public CarDoor getTheDoorByIndex(int index) {
        return doors.get(index);
    }

    public CarWheel getTheWheelByIndex(int index) {
        return wheels.get(index);
    }

    public void wheelsClear() {
        wheels.clear();
    }

    public void addWheels(int newWheelsAmount) {
        for (int i = 0; i < newWheelsAmount; i++) {
            this.wheels.add(new CarWheel());
        }
    }

    public int currentMaxSpeed() {
        int m;
        float temp;
        if (!this.wheels.isEmpty()) {
            temp = this.wheels.get(0).getTyreStatus();
            for (int i = 1; i < this.wheels.size(); i++) {
                if (wheels.get(i).getTyreStatus() < temp) {
                    temp = wheels.get(i).getTyreStatus();
                }
            }
        } else {
            temp = 0f;
        }
        if (this.currentNumberOfPassengers == 0) {
            temp = 0f;
        }
        if (temp == 1f) {
            return this.maxSpeedIfNew;
        }
        m = this.maxSpeedIfNew * (int) (temp * 100) / 100;
        if (this.currentSpeed > m) {
            this.currentSpeed = m;
        }
        return m;
    }

    public void carInfo() {
        currentMaxSpeed();
        System.out.println("Car  " + this.instanceName + "\n"
                + "дата производства  " + this.manufacturingDate + "\n"
                + "тип двигателя  " + motorType + "\n"
                + "максимальная скорость машины (если она новая)  " + this.maxSpeedIfNew + "\n"
                + "время разгона до 100км/ч  " + accelerationTime + "\n"
                + "пассажировместимость  " + passengerCapacity + "\n"
                + "кол-во пассажиров внутри в данный момент  " + currentNumberOfPassengers + "\n"
                + "текущая скорость  " + currentSpeed + " км/ч\n"
                + "\nмассив колес:");
        for (CarWheel i : wheels) {
            i.wheelInfo();
        }
        System.out.println("\nмассив дверей:");
        for (CarDoor i : doors) {
            i.doorInfo();
        }
        System.out.println("\nтекущая возможная максимальная скорость  " + currentMaxSpeed() + " км/ч");
    }

    public void carInterface() {
        Scanner sc = new Scanner(System.in);
        String s;
        int i, j;
        while (true) {
            System.out.println("Enter ('I' - Instruction, 'Q' - Quit):");
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                switch (i) {
                    case 101: {
                        System.out.println("Door to be opened index (" + (this.doors.size() - 1) + " max):");
                        i = intVerifier(this.doors.size());
                        if (this.doors.get(i).getDoorStatus().equals(Status.CLOSED)) {
                            this.doors.get(i).doorOpened();
                            System.out.println(this.doors.get(i).getDoorStatus());
                            break;
                        }
                        System.out.println(this.doors.get(i).getDoorStatus());
                        break;
                    }

                    case 102: {
                        System.out.println("Door to be closed index (" + (this.doors.size() - 1) + " max):");
                        i = intVerifier(this.doors.size());
                        if (this.doors.get(i).getDoorStatus().equals(Status.OPENED)) {
                            this.doors.get(i).doorClosed();
                            System.out.println(this.doors.get(i).getDoorStatus());
                            break;
                        }
                        System.out.println(this.doors.get(i).getDoorStatus());
                        break;
                    }

                    case 103: {
                        System.out.println("Door to be changed index (" + (this.doors.size() - 1) + " max):");
                        i = intVerifier(this.doors.size());
                        this.doors.get(i).doorChanged();
                        System.out.println(this.doors.get(i).getDoorStatus());
                        break;
                    }

                    case 104: {
                        System.out.println("Door to have a window opened index (" + (this.doors.size() - 1) + " max):");
                        i = intVerifier(this.doors.size());
                        if (this.doors.get(i).getWindowStatus().equals(Status.CLOSED)) {
                            this.doors.get(i).windowOpened();
                            System.out.println(this.doors.get(i).getWindowStatus());
                            break;
                        }
                        System.out.println(this.doors.get(i).getWindowStatus());
                        break;
                    }

                    case 105: {
                        System.out.println("Door to have a window closed index (" + (this.doors.size() - 1) + " max):");
                        i = intVerifier(this.doors.size());
                        if (this.doors.get(i).getWindowStatus().equals(Status.OPENED)) {
                            this.doors.get(i).windowClosed();
                            System.out.println(this.doors.get(i).getWindowStatus());
                            break;
                        }
                        System.out.println(this.doors.get(i).getWindowStatus());
                        break;
                    }

                    case 106: {
                        System.out.println("Door to have a window changed index (" + (this.doors.size() - 1) + " max):");
                        i = intVerifier(this.doors.size());
                        this.doors.get(i).windowChanged();
                        System.out.println(this.doors.get(i).getWindowStatus());
                        break;
                    }

                    case 107: {
                        System.out.println("Door to be interested in info index (" + (this.doors.size() - 1) + " max):");
                        i = intVerifier(this.doors.size());
                        this.doors.get(i).doorInfo();
                        break;
                    }

                    case 201: {
                        if (this.wheels.isEmpty()) {
                            System.out.println(this.wheels.size() + " wheels for now.");
                            break;
                        } else {
                            System.out.println("Tyre to be changed index (" + (this.wheels.size() - 1) + " max):");
                        }
                        i = intVerifier(this.wheels.size());
                        this.wheels.get(i).tyreChange();
                        this.wheels.get(i).wheelInfo();
                        break;
                    }

                    case 202: {
                        if (this.wheels.isEmpty()) {
                            System.out.println(this.wheels.size() + " wheels for now.");
                            break;
                        } else {
                            System.out.println("Tyre index (" + (this.wheels.size() - 1) + " max):");
                        }
                        i = intVerifier(this.wheels.size());
                        if ((int) (this.wheels.get(i).getTyreStatus() * 100) == 0) {
                            this.wheels.get(i).wheelInfo();
                            break;
                        }
                        System.out.println("Wear this tyre by ? % (" + (this.wheels.get(i).getTyreStatus() == 1f ? 100 :
                                (int) (this.wheels.get(i).getTyreStatus() * 100)) + " max):");
                        j = intVerifier((int) (this.wheels.get(i).getTyreStatus() * 100) + 1);
                        this.wheels.get(i).tyreWear(j);
                        this.wheels.get(i).wheelInfo();
                        break;
                    }

                    case 203: {
                        if (this.wheels.isEmpty()) {
                            System.out.println(this.wheels.size() + " wheels for now.");
                            break;
                        } else {
                            System.out.println("Wheel to get status index (" + (this.wheels.size() - 1) + " max):");
                        }
                        i = intVerifier(this.wheels.size());
                        System.out.println(this.wheels.get(i).getTyreStatus());
                        break;
                    }

                    case 204: {
                        if (this.wheels.isEmpty()) {
                            System.out.println(this.wheels.size() + " wheels for now.");
                            break;
                        } else {
                            System.out.println("Wheel to be interested in info index (" + (this.wheels.size() - 1) + " max):");
                        }
                        i = intVerifier(this.wheels.size());
                        this.wheels.get(i).wheelInfo();
                        break;
                    }
				
				
                    case 301: {
                        System.out.println("New current speed (" + (this.currentMaxSpeed() == 0 ? this.currentMaxSpeed() :
                                this.currentMaxSpeed() - 1) + "  max): ");
                        i = intVerifier(this.currentMaxSpeed());
                        this.currentSpeedChange(i);
                        System.out.println("Current speed is " + this.currentSpeed);
                        break;
                    }

                    case 302: {
                        if (this.currentNumberOfPassengers == this.passengerCapacity) {
                            System.out.println("The car is full.");
                            break;
                        }
                        this.putOnePassenger();
                        System.out.println(this.currentNumberOfPassengers + " passengers for now.");
                        break;
                    }

                    case 303: {
                        this.dropOffOnePassenger();
                        System.out.println(this.currentNumberOfPassengers + " passengers for now.");
                        break;
                    }

                    case 304: {
                        this.dropOffAllPassengers();
                        System.out.println("The car is empty.");
                        break;
                    }

                    case 305: {
                        System.out.println("Door to get status index (" + (this.doors.size() - 1) + " max):");
                        i = intVerifier(this.doors.size());
                        getTheDoorByIndex(i);
                        this.doors.get(i).doorInfo();
                        break;
                    }

                    case 306: {
                        if (this.wheels.isEmpty()) {
                            System.out.println(this.wheels.size() + " wheels for now.");
                            break;
                        } else {
                            System.out.println("Wheel to get status index (" + (this.wheels.size() - 1) + " max):");
                        }
                        i = intVerifier(this.wheels.size());
                        getTheWheelByIndex(i);
                        this.wheels.get(i).wheelInfo();
                        break;
                    }

                    case 307: {
                        this.wheelsClear();
                        System.out.println(this.wheels.size() + " wheels for now.");
                        break;
                    }

                    case 308: {
                        System.out.println("Add ? wheels:");
                        j = intVerifier((Integer.MAX_VALUE - this.wheels.size()));
                        addWheels(j);
                        System.out.println(this.wheels.size() + " wheels for now.");
                        break;
                    }

                    case 309: {
                        this.currentMaxSpeed();
                        System.out.println("Current max speed: " + this.currentMaxSpeed());
                        break;
                    }

                    case 310: {
                        this.carInfo();
                        break;
                    }
                }
            } else {
                if (sc.hasNextLine()) {
                    s = sc.nextLine();
                    if (s.equalsIgnoreCase("q") || s.equalsIgnoreCase("quit")) {
                        System.out.println("Bye!");
                        System.exit(0);
                    }
                    if (s.equalsIgnoreCase("i")) {
                        instruction();
                    }
                }
            }
        }
    }

    private void instruction() {
        System.out.println("101 - открыть дверь\n102 - закрыть дверь\n103 - открыть/закрыть дверь" +
                "\n104 - открыть окно\n105 - закрыть окно\n106 - открыть/закрыть окно" +
                "\n107 - Вывести в консоль данные об объекте ''Дверь''" +
                "\n201 - Сменить шину на новую\n202 - Стереть шину на X%" +
                "\n203 - Получить состояние (return)\n204 - Вывести в консоль данные об объекте ''Колесо''" +
                "\n301 - Изменить текущую скорость\n302 - Посадить 1 пассажира в машину\n303 - Высадить 1 пассажира" +
                "\n304 - Высадить всех пассажиров\n305 - Получить дверь по индексу\n306 - Получить колесо по индексу" +
                "\n307 - Снять все колеса с машины\n308 - Установить на машину X новых колеса" +
                "\n309 - Вычислить текущую возможную максимальную скорость\n310 - Вывести в консоль данные об объекте");
    }

    private static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }

    private int intVerifier(int upperMerge) {
        Scanner sc = new Scanner(System.in);
        String s;
        while (true) {
            s = sc.nextLine();
            if (s.equalsIgnoreCase("q") || s.equalsIgnoreCase("quit")) {
                System.exit(222);
            } else if (isInt(s.trim()) || s.trim().isEmpty() || Integer.parseInt(s.trim().split(" ")[0]) <= 0
                    || Integer.parseInt(s.trim().split(" ")[0]) >= upperMerge) {
                System.out.println("Re-enter: ");
            } else {
                return Integer.parseInt(s.trim().split(" ")[0]);
            }
        }
    }
}
