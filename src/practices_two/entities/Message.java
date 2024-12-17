package practices_two.entities;

public record Message(
        String text,
        Attachment attachment
) {

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", attachment=" + attachment +
                '}';
    }
}
