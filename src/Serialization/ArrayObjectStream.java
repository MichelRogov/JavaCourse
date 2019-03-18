package Serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArrayObjectStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("Alex", 30);
        Employee employee = new Employee("Financial", person);
        Employee employee2 = new Employee("Trash Manager", person);

        List<Employee> list = new ArrayList<>();

        list.add(employee);
        list.add(employee2);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("employeesArr.bin"));
        objectOutputStream.writeObject(list);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("employeesArr.bin"));
        List<Employee> inputList = (List<Employee>) objectInputStream.readObject();

        inputList.forEach(System.out::println);

    }
}
