package com.company;

public class FishBread {
    String name;
    float flourRatio;
    float weight;
    float beanRatio;

    public FishBread(String name, float weight) {
        this.name = name;
        this.weight = weight;
        flourRatio = (float) Math.random();
        beanRatio = (float) Math.random() * (1 - flourRatio);
    }

    public float getFlour() {
        return flourRatio * weight;
    }

    private float getBean() {
        return beanRatio * weight;
    }

    public void describe() {
        System.out.println("Name:" + name);
        System.out.println("Weight:" + weight);
        System.out.println("Flour:" + getFlour());
        System.out.println("Bean:" + getBean());
    }
}
