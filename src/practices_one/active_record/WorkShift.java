package practices_one.active_record;

import java.time.LocalDateTime;

public class WorkShift {
    private LocalDateTime start;
    private LocalDateTime end;

    public WorkShift(LocalDateTime start, LocalDateTime end) {
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Некорректное время смены");
        }
        this.start = start;
        this.end = end;
    }

    public boolean isWithinShift(LocalDateTime time) {
        return (time.isEqual(start) || time.isAfter(start)) && time.isBefore(end);
    }

    public boolean overlaps(LocalDateTime otherStart, LocalDateTime otherEnd) {
        return (start.isBefore(otherEnd) && end.isAfter(otherStart));
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "WorkShift{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
