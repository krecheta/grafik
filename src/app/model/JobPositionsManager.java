package app.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Class responsible for storing job positions data.
 */
public class JobPositionsManager {

    /**
     * Job positions list.
     */
    private ObservableList<JobPosition> jobPositionList = FXCollections.observableArrayList();

    /**
     * Adds job positions to the list.
     * @param newValue - job position
     */
    public void addJobPosition(JobPosition newValue) {
        jobPositionList.add(newValue);
    }

    /**
     * Removes job position from list.
     * @param oldValue
     */
    public void removeJobPosition(JobPosition oldValue) {
        jobPositionList.remove(oldValue);
    }

    //***************** getters and setters area *****************
    public ObservableList<JobPosition> getJobPositionList() {
        return jobPositionList;
    }
}
