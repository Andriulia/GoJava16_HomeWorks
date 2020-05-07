package Main.Java.Car;

class CarDoor {
    private Status doorStatus;
    private Status windowStatus;

    CarDoor() {
        this.doorStatus = Status.CLOSED;
        this.windowStatus = Status.CLOSED;
    }

    CarDoor(Status doorStatus, Status windowStatus) {
        this.doorStatus = doorStatus;
        this.windowStatus = windowStatus;
    }

    Status getDoorStatus() {
        return doorStatus;
    }

    Status getWindowStatus() {
        return windowStatus;
    }

    void doorOpened() {
        this.doorStatus = Status.OPENED;
    }

    void doorClosed() {
        this.doorStatus = Status.CLOSED;
    }

    void doorChanged() {
        if (this.doorStatus.equals(Status.CLOSED)) {
            this.doorStatus = Status.OPENED;
        } else {
            this.doorStatus = Status.CLOSED;
        }
    }

    void windowOpened() {
        this.windowStatus = Status.OPENED;
    }

    void windowClosed() {
        this.windowStatus = Status.CLOSED;
    }

    void windowChanged() {
        if (this.windowStatus.equals(Status.CLOSED)) {
            this.windowStatus = Status.OPENED;
        } else {
            this.windowStatus = Status.CLOSED;
        }
    }

    void doorInfo() {
        System.out.println("The door is " + doorStatus + ", and the window is " + windowStatus);
    }
}
