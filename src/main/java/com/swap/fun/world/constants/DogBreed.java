package com.swap.fun.world.constants;

public enum DogBreed {

    SHEPHERD("SHEPHERD"),
    HUSKY("HUSKY");


    private String name;

    DogBreed(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
