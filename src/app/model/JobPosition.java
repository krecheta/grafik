package app.model;

import java.time.Duration;
import java.time.LocalTime;

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
     * Creates position and initializes all fields.
     * @param name - name of position
     * @param startTime - time to start work
     * @param endTime - time to end work
     */
    public JobPosition(String name, LocalTime startTime, LocalTime endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        workDuration = Duration.between(startTime, endTime).toHours();
    }
}
