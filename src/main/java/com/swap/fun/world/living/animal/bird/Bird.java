package com.swap.fun.world.living.animal.bird;

import com.swap.fun.world.constants.FoodBrand;
import com.swap.fun.world.living.animal.Animal;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bird bird = (Bird) o;
        return Float.compare(bird.wingSpan, wingSpan) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wingSpan);
    }
}
