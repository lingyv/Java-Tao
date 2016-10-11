package org.lingyv.JDK.reflect;

public class Dog {
    private String name;
    private String colour;
    private int age;

    public void bark() {
        System.out.println("汪~汪~汪~");
    }

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
