package com.company;

public class FishBread {
    float weight;
    String name;
    float flourRatio;
    float beanRatio;

    void describe() {
        System.out.println("name:" + name);
        System.out.println("weight:" + weight);
        System.out.println("flour ratio:" + flourRatio);
        System.out.println("bean ratio:" + beanRatio);
        foo();
    }

    FishBread(String n, float w) {
        this.name = n;
        this.weight = w;
        this.flourRatio = 0.4f;
        this.beanRatio = 0.4f;
    }

    static void foo() {
        System.out.println("요리법 븝브");
//        describe()
    }
}
