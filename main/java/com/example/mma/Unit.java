package com.example.mma;

import java.io.Serializable;

public class Unit implements Serializable {
    private String type;
    private String unit;
    private Double scalingFactor;

    public Unit() {
    }

    public Unit(String type, String unit, Double scalingFactor) {
        this.type = type;
        this.unit = unit;
        this.scalingFactor = scalingFactor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getScalingFactor() {
        return scalingFactor;
    }

    public void setScalingFactor(Double scalingFactor) {
        this.scalingFactor = scalingFactor;
    }

    @Override
    public String toString() {
        return unit;
    }
}
