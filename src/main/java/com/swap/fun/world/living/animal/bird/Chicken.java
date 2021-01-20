package com.swap.fun.world.living.animal.bird;

import com.swap.fun.world.constants.FoodBrand;
import com.swap.fun.world.living.animal.Animal;

import java.util.Objects;

public class Chicken extends Bird {

    protected boolean laysEgg;

    public Chicken() {
    }

    public Chicken(String name) {
        super(name);
    }

    public Chicken(boolean laysEgg) {
        this.laysEgg = laysEgg;
    }

    public Chicken(float wingSpan, boolean laysEgg) {
        super(wingSpan);
        this.laysEgg = laysEgg;
    }

    public Chicken(String name, FoodBrand favFood, boolean laysEgg, float wingSpan) {
        super(name, favFood, wingSpan);
        this.laysEgg = laysEgg;
    }

    public Chicken(String name, Animal bestFriendForever, FoodBrand favFood, boolean laysEgg, float wingSpan) {
        super(name, bestFriendForever, favFood, wingSpan);
        this.laysEgg = laysEgg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Chicken chicken = (Chicken) o;
        return laysEgg == chicken.laysEgg;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), laysEgg);
    }
}
