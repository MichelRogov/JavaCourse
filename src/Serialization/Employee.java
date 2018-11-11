package Serialization;

import java.io.Serializable;

public class Employee implements Serializable {

    private String department;

    private Person person;

    public Employee(String department, Person person) {
        this.department = department;
        this.person = person;
    }

    public String getDepartment() {
        return department;
    }

    public Person getPerson() {
        return person;
    }
}
