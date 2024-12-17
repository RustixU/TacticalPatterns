package practices_two.domain_services;

import practices_two.entities.TransportationOrder;

public class FraudDetectionService {
    public boolean checkForFraud(TransportationOrder order) {
        return order.getRoute() == null || order.getMessages().isEmpty();
    }
}
