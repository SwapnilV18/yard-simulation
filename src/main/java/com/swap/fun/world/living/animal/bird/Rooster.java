package com.swap.fun.world.living.animal.bird;

import com.swap.fun.world.constants.FoodBrand;
import com.swap.fun.world.living.animal.Animal;

public class Rooster extends Bird {

    public Rooster() {
    }

    public Rooster(String name) {
        super(name);
    }

    public Rooster(float wingSpan) {
        super(wingSpan);
    }

    public Rooster(String name, FoodBrand favFood, float wingSpan) {
        super(name, favFood, wingSpan);
    }

    public Rooster(String name, Animal bestFriendForever, FoodBrand favFood, float wingSpan) {
        super(name, bestFriendForever, favFood, wingSpan);
    }
}
