package com.swap.fun.world.living.animal.bird;

import com.swap.fun.world.constants.FoodBrand;
import com.swap.fun.world.living.animal.Animal;

public abstract class Bird extends Animal {

    protected float wingSpan;

    public Bird() {
    }

    public Bird(String name) {
        super(name);
    }

    public Bird(float wingSpan) {
        this.wingSpan = wingSpan;
    }

    public Bird(String name, FoodBrand favFood, float wingSpan) {
        super(name, favFood);
        this.wingSpan = wingSpan;
    }

    public Bird(String name, Animal bestFriendForever, FoodBrand favFood, float wingSpan) {
        super(name, bestFriendForever, favFood);
        this.wingSpan = wingSpan;
    }
}
