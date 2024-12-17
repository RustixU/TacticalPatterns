package practices_one.active_record;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Репозиторий для хранения водителей
public class DriverScheduleRepository {
    private final Map<Integer, Driver> storage = new HashMap<>();

    public void save(Driver driver) {
        storage.put(driver.getId(), driver);
        System.out.println("Водитель сохранен: " + driver);
    }

    public Driver findById(int id) {
        return storage.get(id);
    }

    public List<Driver> findAll() {
        return new ArrayList<>(storage.values());
    }
}

