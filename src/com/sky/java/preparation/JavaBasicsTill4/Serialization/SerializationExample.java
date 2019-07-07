package com.sky.java.preparation.JavaBasicsTill4.Serialization;

import com.sky.java.preparation.JavaBasicsTill4.Serialization.object.Person;

import java.io.*;

public class SerializationExample {
    public static void main(String[] args) {
        Person person = new Person();
        person.setId(1);
        person.setName("Sumit");
        person.setCity("ABC");

        try (FileOutputStream fileOutputStream = new FileOutputStream("people.bin")) {
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(person);
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fileInputStream = new FileInputStream("people.bin")) {
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            Person person1= (Person)inputStream.readObject();
            System.out.println(person1.getId());
            System.out.println(person1.getName());
            System.out.println(person1.getCity());
            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
