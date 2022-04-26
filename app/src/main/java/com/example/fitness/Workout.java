package com.example.fitness;

public class Workout {
    String workOutName;
    String description;
    String days;

    public Workout(String workOutName, String description, String days) {
        this.workOutName = workOutName;
        this.description = description;
        this.days = days;
    }

    public String getWorkOutName() {
        return workOutName;
    }

    public void setWorkOutName(String workOutName) {
        this.workOutName = workOutName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }
}
