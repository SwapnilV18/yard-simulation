package com.swap.fun.world.living.animal.mammal;

import com.swap.fun.world.constants.DogBreed;
import com.swap.fun.world.constants.FoodBrand;
import com.swap.fun.world.living.animal.Animal;

import java.util.Objects;

public class Dog extends Mammal {

    private DogBreed dogBreed;

    public Dog() {
    }

    public DogBreed getDogBreed() {
        return dogBreed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return getDogBreed() == dog.getDogBreed();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDogBreed());
    }

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
