package app.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Class responsible for storing employees data.
 */
public class EmployeesManager {
    /**
     * Employees list.
     */
    private ObservableList<Employee> employeesList = FXCollections.observableArrayList();

    /**
     * Adds employee to the list.
     * @param newEmp - Employee
     */
    public void addEmployee(Employee newEmp) {
        employeesList.add(newEmp);
    }

    /**
     * Removes employee from list.
     * @param oldEmp - Employee
     */
    public void removeEmployee(Employee oldEmp) {
        employeesList.remove(oldEmp);
    }

    /**
     * Moves employee up or down on the list.
     * @param emp - Employee
     * @param b - If true, move up. If false, move down.
     */
    public void moveEmployeeOnList(Employee emp, boolean b) {
        int index = employeesList.indexOf(emp);
        if(b) {
            Collections.swap(employeesList, index, index-1);
        } else {
            Collections.swap(employeesList, index, index+1);
        }
    }

    //***************** getters and setters area *****************
    public ObservableList<Employee> getEmpList() {
        return employeesList;
    }
}
