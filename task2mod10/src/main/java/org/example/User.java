package org.example;

public class User {

    static final String PATH_JSON_FILE = null;
    private String name;
    private int age;
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person {name = \"" + name + "\", age = " + age + "}";
    }
}
