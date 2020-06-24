package com.yhtos.tcs.util;

public class Car {

    private String name;
    private String energ;
    private String location;
    private String state;
    private Position position;

    public Car() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnerg() {
        return energ;
    }

    public void setEnerg(String energ) {
        this.energ = energ;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", energ='" + energ + '\'' +
                ", location='" + location + '\'' +
                ", state='" + state + '\'' +
                ", position='" + position.toString() + '\'' +
                '}';
    }
}
