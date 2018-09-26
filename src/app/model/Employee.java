package app.model;

import java.util.Objects;

/**
 * Represents single employee.
 */
public class Employee {

    /**
     * Name of employee. Must be unique.
     */
    private String name;

    /**
     * Creates employee and initializes name.
     * @param name - name of employee
     */
    public Employee(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    //***************** getters and setters area *****************
    public String getName() {
        return name;
    }

}
