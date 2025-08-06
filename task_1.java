interface Transport {
    void move();
}

abstract class PassengerTransport {
    private int capacity;

    public PassengerTransport(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public abstract void hasCapacity();
}

class Engine {
    private String engineType;

    public Engine(String engineType) {
        this.engineType = engineType;
    }

    public String getEngineType() {
        return engineType;
    }
}

class Train extends PassengerTransport implements Transport {
    private Engine engine;
    private String route;

    public Train(int capacity, String engineType, String route) {
        super(capacity);
        this.engine = new Engine(engineType);
        this.route = route;
    }

    @Override
    public void move() {
        System.out.println("Train is moving on track via " + route + " with " + engine.getEngineType() + " engine.");
    }

    @Override
    public void hasCapacity() {
        System.out.println("Train has seating capacity of " + getCapacity() + " passengers.");
    }
}

class Airplane extends PassengerTransport implements Transport {
    private Engine engine;
    private String airline;

    public Airplane(int capacity, String engineType, String airline) {
        super(capacity);
        this.engine = new Engine(engineType);
        this.airline = airline;
    }

    @Override
    public void move() {
        System.out.println("Airplane is flying under " + airline + " with " + engine.getEngineType() + " engine.");
    }

    @Override
    public void hasCapacity() {
        System.out.println("Airplane has seating capacity of " + getCapacity() + " passengers.");
    }
}

public class Main {
    public static void main(String[] args) {
        Transport t1 = new Train(300, "Diesel", "Delhi–Mumbai");
        Transport t2 = new Airplane(180, "Jet", "IndiGo");

        PassengerTransport pt1 = (PassengerTransport) t1;
        PassengerTransport pt2 = (PassengerTransport) t2;

        System.out.println("=== Transport Details ===");
        t1.move();
        pt1.hasCapacity();

        System.out.println();

        t2.move();
        pt2.hasCapacity();
    }
}
