package com.swap.fun.world.living.animal;

import com.swap.fun.world.constants.FoodBrand;
import com.swap.fun.world.living.Friend;
import com.swap.fun.world.living.LivingBeing;


public abstract class Animal extends LivingBeing {


    protected FoodBrand favFood;

    public Animal() {
    }

    public Animal(String name) {
        super(name);
    }

    public Animal(String name, FoodBrand favFood) {
        super(name);
        this.favFood = favFood;
    }

    public Animal(String name, Animal bestFriendForever, FoodBrand favFood) {
        super(name);
        this.favFood = favFood;
        this.setBestFriendForever(bestFriendForever);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FoodBrand getFavFood() {
        return favFood;
    }

    public void setFavFood(FoodBrand favFood) {
        this.favFood = favFood;
    }

    public void setBestFriendForever(Animal animal) {
        this.friendList.add(new Friend(animal, true));
    }

    /*
    equals method deals with only name as the uniqueness param for this simulation exercise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return getName().equals(animal.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
