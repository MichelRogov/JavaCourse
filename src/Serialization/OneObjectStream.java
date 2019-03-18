package Serialization;

import java.io.*;

public class OneObjectStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("Alex", 30);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("persons.bin"));

        objectOutputStream.writeObject(person);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("persons.bin"));
        Person inputPerson = (Person) objectInputStream.readObject();

        System.out.println(inputPerson);


        ObjectOutputStream objectOutputStreamString = new ObjectOutputStream(new FileOutputStream("string.bin"));

        objectOutputStreamString.writeUTF("cool string");
        objectOutputStreamString.writeUTF("cool string2");
        objectOutputStreamString.close();

        ObjectInputStream objectInputStreamString = new ObjectInputStream(new FileInputStream("string.bin"));
        String inputStream = objectInputStreamString.readUTF();
        String inputStream2 = objectInputStreamString.readUTF();

        System.out.println(inputStream + " " + inputStream2);
    }
}
