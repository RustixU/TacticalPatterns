package practices_two.entities;

import practices_two.entities.enums.OrderStatus;

import java.util.ArrayList;
import java.util.List;

public class TransportationOrder {
    private final Integer orderId;
    private OrderStatus status;
    private final DeliveryRoute route;
    private final List<Message> messages;

    public TransportationOrder(Integer orderId, DeliveryRoute route) {
        this.orderId = orderId;
        this.route = route;
        this.status = OrderStatus.CREATED;
        this.messages = new ArrayList<>();
    }

    // Добавление сообщения с вложением
    public void addMessage(String text, Attachment attachment) {
        if (!status.equals(OrderStatus.ACTIVE)) {
            throw new IllegalStateException("Сообщения можно добавлять только к активной заявке");
        }
        messages.add(new Message(text, attachment));
        checkConsistency();
    }

    // Подтверждение активности
    public void confirmActivity() {
        if (messages.isEmpty()) {
            status = OrderStatus.CLOSED;
        }
    }

    // Обновление статуса заказа, если сообщение пустое
    private void checkConsistency() {
        if (messages.isEmpty()) {
            status = OrderStatus.CLOSED;
        }
    }



    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public DeliveryRoute getRoute() {
        return route;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Integer getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "TransportationOrder{" +
                "orderId=" + orderId +
                ", status=" + status +
                ", route=" + route +
                ", messages=" + messages +
                '}';
    }
}
