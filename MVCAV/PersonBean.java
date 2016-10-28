package com.company;
import java.io.Serializable;

public class PersonBean implements Serializable {
    private String firstName;
    private String lastName;
    private int age;
    private String position;

    public PersonBean() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() { return this.position; }

    public void setPosition(String position) { this.position = position; }

    @Override
    public String toString() {
        return "PersonBean{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age + '\'' +
                ", position=" + position +
                '}';
    }
}



