package com.swap.fun.world.living.animal.mammal;

import com.swap.fun.world.constants.DogBreed;
import com.swap.fun.world.constants.FoodBrand;
import com.swap.fun.world.living.animal.Animal;

public class Dog extends Mammal {

    private DogBreed dogBreed;

    public Dog(String name) {
        super(name);
    }

    public Dog(DogBreed dogBreed) {
        this.dogBreed = dogBreed;
    }

    public Dog(String name, DogBreed dogBreed, FoodBrand favFood) {
        super(name, favFood);
        this.dogBreed = dogBreed;
    }

    public Dog(String name, DogBreed dogBreed, Animal bestFriendForever, FoodBrand favFood) {
        super(name, bestFriendForever, favFood);
        this.dogBreed = dogBreed;
    }

}
