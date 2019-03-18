package Serialization;

import java.io.*;

public class NestedObjectsStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("Alex", 30);
        Employee employee = new Employee("Financial", person);
        Employee employee2 = new Employee("Trash Manager", person);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("employees.bin"));

        objectOutputStream.writeObject(employee);
        objectOutputStream.writeObject(employee2);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("employees.bin"));
        Employee inputEmployee = (Employee) objectInputStream.readObject();
        Employee inputEmployee2 = (Employee) objectInputStream.readObject();

        System.out.println(inputEmployee);
        System.out.println(inputEmployee2);

        System.out.println(inputEmployee.getPerson().equals(inputEmployee2.getPerson()));
    }
}
