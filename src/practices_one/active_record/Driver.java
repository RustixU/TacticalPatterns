package practices_one.active_record;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Driver {
    private Integer id;
    private String fullName;
    private final boolean isActive;
    private final List<WorkShift> workShifts;

    public Driver(Integer id, String fullName, boolean isActive) {
        this.id = id;
        this.fullName = fullName;
        this.isActive = isActive;
        this.workShifts = new ArrayList<>();
    }

    public void addWorkShift(WorkShift workShift) {
        for (WorkShift ws : workShifts) {
            if (ws.equals(workShift)) {
                throw new IllegalArgumentException("Дублирующая рабочая смена");
            }
        }

        workShifts.add(workShift);
    }

    public boolean isAvailableAt(LocalDateTime time) {
        return workShifts.stream().noneMatch(shift -> shift.isWithinShift(time));
    }

    public List<WorkShift> getShiftsByDate(LocalDateTime date) {
        List<WorkShift> result = new ArrayList<>();
        for (WorkShift shift : workShifts) {
            if (shift.getStart().toLocalDate().equals(date.toLocalDate())) {
                result.add(shift);
            }
        }
        return result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", isActive=" + isActive +
                ", workShifts=" + workShifts +
                '}';
    }
}
