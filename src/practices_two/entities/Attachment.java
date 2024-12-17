package practices_two.entities;

public record Attachment(
        String fileName
) {

    @Override
    public String toString() {
        return "Attachment{" +
                "fileName='" + fileName + '\'' +
                '}';
    }
}
