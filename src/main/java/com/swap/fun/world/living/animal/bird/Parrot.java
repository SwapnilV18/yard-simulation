package com.swap.fun.world.living.animal.bird;

import com.swap.fun.world.constants.FoodBrand;
import com.swap.fun.world.living.animal.Animal;

import java.util.Objects;

public class Parrot extends Bird {

    protected boolean canSpeak;

    public Parrot() {
    }

    public Parrot(String name) {
        super(name);
    }

    public Parrot(boolean canSpeak) {
        this.canSpeak = canSpeak;
    }

    public Parrot(float wingSpan, boolean canSpeak) {
        super(wingSpan);
        this.canSpeak = canSpeak;
    }

    public Parrot(String name, FoodBrand favFood, boolean canSpeak, float wingSpan) {
        super(name, favFood, wingSpan);
        this.canSpeak = canSpeak;
    }

    public Parrot(String name, Animal bestFriendForever, FoodBrand favFood, boolean canSpeak, float wingSpan) {
        super(name, bestFriendForever, favFood, wingSpan);
        this.canSpeak = canSpeak;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Parrot parrot = (Parrot) o;
        return canSpeak == parrot.canSpeak;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), canSpeak);
    }
}
