package practices_one.active_record;

// Фабрика для создания сущностей Driver
public class DriverFactory {

    private static int idCounter = 1;

    public static Driver createDriver(String fullName, boolean isActive) {
        return new Driver(idCounter++, fullName, isActive);
    }
}
