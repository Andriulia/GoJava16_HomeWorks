package Main.Java.Car;

class CarWheel {
    private float tyreStatus;

    CarWheel() {
        this.tyreStatus = 1f;
    }

    CarWheel(float tyreStatus) {
        this.tyreStatus = tyreStatus;
    }

    void tyreChange() {
        this.tyreStatus = 1f;
    }

    void tyreWear(int newWearing) {
        this.tyreStatus -= (float) newWearing / 100;
    }

    float getTyreStatus() {
        return this.tyreStatus;
    }

    void wheelInfo() {
        if (tyreStatus * 100 < 1f) {
            System.out.println("The tyre is worn at all.");
        } else if (tyreStatus == 1f) {
            System.out.println("The tyre is not worn at all.");
        } else {
            System.out.println("The tyre is worn by " + (int) (100 - tyreStatus * 100) + " percents.");
        }
    }
}
