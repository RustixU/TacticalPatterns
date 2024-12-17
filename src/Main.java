import practices_one.active_record.Driver;
import practices_one.active_record.DriverFactory;
import practices_one.active_record.DriverScheduleRepository;
import practices_one.active_record.WorkShift;
import practices_one.transaction_script.ScheduleTransactionScript;
import practices_two.domain_services.*;
import practices_two.entities.Attachment;
import practices_two.entities.DeliveryRoute;
import practices_two.entities.TransportationOrder;
import practices_two.entities.enums.OrderStatus;
import practices_two.repositories.InMemoryTransportationOrderRepository;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
/*        // Создание фабрики и репозитория
        DriverScheduleRepository repository = new DriverScheduleRepository();
        Driver driver = DriverFactory.createDriver("Smith Thatcher", true);
        repository.save(driver);

        // Создание транзакционного скрипта
        ScheduleTransactionScript transactionScript = new ScheduleTransactionScript(repository);

        // Добавление смены
        transactionScript.addWorkShiftToDriver(driver.getId(),
                LocalDateTime.of(2024, 12, 16, 10, 0),
                LocalDateTime.of(2024, 12, 16, 12, 0));
        transactionScript.addWorkShiftToDriver(driver.getId(),
                LocalDateTime.of(2024, 12, 8, 14, 0),
                LocalDateTime.of(2024, 12, 8, 16, 0));

        // Проверка смен
        List<WorkShift> sessions = transactionScript.getWorkShiftsForDriverOnDate(driver.getId(),
                LocalDateTime.of(2024, 12, 16, 0, 0));
        System.out.println("Смена на 2024-12-16: " + sessions);

        // Проверка доступности
        boolean isAvailable = transactionScript.checkDriverAvailability(driver.getId(),
                LocalDateTime.of(2024, 12, 16, 11, 0));
        System.out.println("Доступность на 2024-12-16 11:00: " + isAvailable);*/

        InMemoryTransportationOrderRepository repository = new InMemoryTransportationOrderRepository();
        OrderLifecycleService lifecycleService = new OrderLifecycleService();
        FraudDetectionService fraudService = new FraudDetectionService();

        // Создание заявки
        TransportationOrder order = new TransportationOrder(12345, new DeliveryRoute("Moscow", "Kazan"));
//        order.setStatus(OrderStatus.ACTIVE);
        repository.save(order);

        // Добавление сообщения
        order.addMessage("Первое сообщение", new Attachment("document.pdf"));
        repository.save(order);

        // Обновление статуса заявки
        lifecycleService.updateStatus(order, OrderStatus.ACTIVE);
        repository.save(order);

        // Проверка на фрод
        if (fraudService.checkForFraud(order)) {
            System.out.println("Обнаружена подозрительная активность!");
        } else {
            System.out.println("Заказ действителен.");
        }

        // Получение заявки из репозитория
        TransportationOrder loadedOrder = repository.findById(12345).orElseThrow();
        System.out.println("Статус заказа: " + loadedOrder.getStatus());
    }
}
