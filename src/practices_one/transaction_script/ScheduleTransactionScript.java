package practices_one.transaction_script;

import practices_one.active_record.Driver;
import practices_one.active_record.DriverScheduleRepository;
import practices_one.active_record.WorkShift;

import java.time.LocalDateTime;
import java.util.List;

public class ScheduleTransactionScript {
    private final DriverScheduleRepository repository;

    public ScheduleTransactionScript(DriverScheduleRepository repository) {
        this.repository = repository;
    }

    public void addWorkShiftToDriver(int driverId, LocalDateTime start, LocalDateTime end) {
        Driver driver = repository.findById(driverId);
        if (driver == null) {
            throw new IllegalArgumentException("Преподаватель с ID " + driverId + " не найден.");
        }
        try {
            System.out.println("Начало транзакции добавления смены.");
            driver.addWorkShift(new WorkShift(start, end));
            repository.save(driver);
            System.out.println("Транзакция успешно завершена: Смена добавлена.");
        } catch (Exception e) {
            System.err.println("Ошибка транзакции: " + e.getMessage());
        }
    }

    public List<WorkShift> getWorkShiftsForDriverOnDate(int instructorId, LocalDateTime date) {
        Driver driver = repository.findById(instructorId);
        if (driver == null) {
            throw new IllegalArgumentException("Водитель с ID " + instructorId + " не найден.");
        }
        System.out.println("Получение списка смен для водителя на дату: " + date.toLocalDate());
        return driver.getShiftsByDate(date);
    }

    public boolean checkDriverAvailability(int instructorId, LocalDateTime dateTime) {
        Driver driver = repository.findById(instructorId);
        if (driver == null) {
            throw new IllegalArgumentException("Водитель с ID " + instructorId + " не найден.");
        }
        System.out.println("Проверка доступности водителя на момент времени: " + dateTime);
        return driver.isAvailableAt(dateTime);
    }
}
