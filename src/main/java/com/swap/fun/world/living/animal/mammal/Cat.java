package com.swap.fun.world.living.animal.mammal;

import com.swap.fun.world.constants.FoodBrand;
import com.swap.fun.world.living.animal.Animal;

public class Cat extends Mammal {

    public Cat() {
    }

    public Cat(String name) {
        super(name);
    }

    public Cat(String name, FoodBrand favFood) {
        super(name, favFood);
    }

    public Cat(String name, Animal bestFriendForever, FoodBrand favFood) {
        super(name, bestFriendForever, favFood);
    }


}
