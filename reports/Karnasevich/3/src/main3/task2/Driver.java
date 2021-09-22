package main3.task2;

import java.util.Objects;


public class Driver {

    private final String name;

    private final String surname;

    public Driver(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(name, driver.name) && Objects.equals(surname, driver.surname);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
