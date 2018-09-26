package app.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Objects;

/**
 * Represents single position in company.
 */
public class JobPosition {
    /**
     * Name of position.
     */
    private String name;

    /**
     * Time to start work on this position.
     */
    private LocalTime startTime;

    /**
     * Time to end work on this position.
     */
    private LocalTime endTime;

    /**
     * Duration of work on this position.
     */
    private double workDuration;

    /**
     * Symbol of job position used in app. Must be unique.
     */
    private String internalSymbol;

    /**
     * Symbol of job position used in final excel sheet.
     */
    private String externalSymbol;

    /**
     * Creates position and initializes all fields.
     * @param name - name of position
     * @param startTime - time to start work
     * @param endTime - time to end work
     */
    public JobPosition(String name, LocalTime startTime, LocalTime endTime,
                       String internalSymbol, String externalSymbol) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        workDuration = Duration.between(startTime, endTime).toHours();
        this.internalSymbol = internalSymbol;
        this.externalSymbol = externalSymbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobPosition that = (JobPosition) o;
        return Objects.equals(internalSymbol, that.internalSymbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(internalSymbol);
    }

    @Override
    public String toString() {
        return this.name;
    }

    //***************** getters and setters area *****************
    public String getName() {
        return name;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public double getWorkDuration() {
        return workDuration;
    }

    public String getInternalSymbol() {
        return internalSymbol;
    }

    public String getExternalSymbol() {
        return externalSymbol;
    }

}
