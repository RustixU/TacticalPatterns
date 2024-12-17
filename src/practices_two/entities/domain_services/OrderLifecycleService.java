package practices_two.entities.domain_services;

import practices_two.entities.TransportationOrder;
import practices_two.entities.enums.OrderStatus;

public class OrderLifecycleService {
    public void updateStatus(TransportationOrder order, OrderStatus newStatus) {
        if (order == null) {
            throw new IllegalArgumentException("Заказ не может быть пустым");
        }
        order.setStatus(newStatus);
    }
}
