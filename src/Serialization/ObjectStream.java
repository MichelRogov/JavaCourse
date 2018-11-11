package Serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person person = new Person("Alex", 30);
        Employee employee = new Employee("Finance", person);
        Employee employee2 = new Employee("Trash - Keeper", person);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("employees.bin"));

        objectOutputStream.writeObject(employee);
        objectOutputStream.writeObject(employee2);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("employees.bin"));

//        Person inputPerson = (Person) objectInputStream.readObject();

        Employee employeeFromFile = (Employee) objectInputStream.readObject();
        Employee employeeFromFile2 = (Employee) objectInputStream.readObject();


        System.out.println(employeeFromFile.getPerson().getName() + " " + employeeFromFile.getPerson().getAge() + " " + employeeFromFile.getDepartment());
        System.out.println(employeeFromFile2.getPerson().getName() + " " + employeeFromFile2.getPerson().getAge() + " " + employeeFromFile2.getDepartment());

        System.out.println(employeeFromFile.getPerson());
        System.out.println(employeeFromFile2.getPerson());

        ObjectOutputStream objectOutputStreamForList = new ObjectOutputStream(new FileOutputStream("arrayList.bin"));

        ArrayList<Employee> arrayList = new ArrayList<>();
        arrayList.add(employee);
        arrayList.add(employee2);
        objectOutputStreamForList.writeObject(arrayList);

        ObjectInputStream objectInputStreamFromList = new ObjectInputStream(new FileInputStream("arrayList.bin"));

        List<Employee> employeeListFromFile = (List<Employee>) objectInputStreamFromList.readObject();
        employeeListFromFile.stream().forEach( e -> System.out.println(e.getPerson().getName() + " " + e.getPerson().getAge() + " " + e.getDepartment()));
    }
}
