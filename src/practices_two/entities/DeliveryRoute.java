package practices_two.entities;

import java.util.Objects;

public record DeliveryRoute(
        String startPoint,
        String endPoint
) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeliveryRoute that)) return false;
        return Objects.equals(endPoint, that.endPoint) && Objects.equals(startPoint, that.startPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPoint, endPoint);
    }

    @Override
    public String toString() {
        return "DeliveryRoute{" +
                "startPoint='" + startPoint + '\'' +
                ", endPoint='" + endPoint + '\'' +
                '}';
    }
}
