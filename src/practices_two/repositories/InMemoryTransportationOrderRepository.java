package practices_two.repositories;

import practices_two.entities.TransportationOrder;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryTransportationOrderRepository {
    private final Map<Integer, TransportationOrder> storage = new HashMap<>();

    public void save(TransportationOrder order) {
        storage.put(order.getOrderId(), order);
    }

    public Optional<TransportationOrder> findById(Integer orderId) {
        return Optional.ofNullable(storage.get(orderId));
    }

    public void delete(Integer orderId) {
        storage.remove(orderId);
    }
}
