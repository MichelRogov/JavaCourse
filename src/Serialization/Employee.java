package Serialization;

import java.io.Serializable;

public class Employee implements Serializable {
    private String department;
    private Person person;

    public Employee(String department, Person person) {
        this.department = department;
        this.person = person;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "department='" + department + '\'' +
                ", person=" + person +
                '}';
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
