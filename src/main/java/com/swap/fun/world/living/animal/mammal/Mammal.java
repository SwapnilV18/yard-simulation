package com.swap.fun.world.living.animal.mammal;

import com.swap.fun.world.constants.FoodBrand;
import com.swap.fun.world.living.animal.Animal;

public abstract class Mammal extends Animal {


    public Mammal() {
    }

    public Mammal(String name) {
        super(name);
    }

    public Mammal(String name, FoodBrand favFood) {
        super(name, favFood);
    }

    public Mammal(String name, Animal bestFriendForever, FoodBrand favFood) {
        super(name, bestFriendForever, favFood);
    }
}
