package app.model;

/**
 * Represents single employee.
 */
public class Employee {

    /**
     * Name of employee.
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

    //***************** getters and setters area *****************
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
