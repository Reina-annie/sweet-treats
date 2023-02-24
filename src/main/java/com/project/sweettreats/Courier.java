package com.project.sweettreats;


import java.time.LocalTime;


public class Courier {

    String name;
    double ratePerMile;
    int distanceDelivered;
    LocalTime startTime;
    LocalTime endTime;
    boolean hasARefrigeratedBox;


    public Courier(String name, double ratePerMile, int distanceDelivered, LocalTime startTime, LocalTime endTime, boolean hasARefrigeratedBox) {
        this.name = name;
        this.ratePerMile = ratePerMile;
        this.distanceDelivered = distanceDelivered;
        this.startTime = startTime;
        this.endTime = endTime;
        this.hasARefrigeratedBox = hasARefrigeratedBox;
    }

    public Courier() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRatePerMile() {
        return ratePerMile;
    }

    public void setRatePerMile(double ratePerMile) {
        this.ratePerMile = ratePerMile;
    }

    public int getDistanceDelivered() {
        return distanceDelivered;
    }

    public void setDistanceDelivered(int distanceDelivered) {
        this.distanceDelivered = distanceDelivered;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public boolean isHasARefrigeratedBox() {
        return hasARefrigeratedBox;
    }

    public void setHasARefrigeratedBox(boolean hasARefrigeratedBox) {
        this.hasARefrigeratedBox = hasARefrigeratedBox;
    }

}
