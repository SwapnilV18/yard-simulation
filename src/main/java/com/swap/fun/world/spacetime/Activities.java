package com.swap.fun.world.spacetime;

import com.swap.fun.world.constants.FoodBrand;
import com.swap.fun.world.inout.Output;
import com.swap.fun.world.living.animal.Animal;
import com.swap.fun.world.mind.animal.AnimalBehaviour;

import java.util.*;

public class Activities {

    // create a map of brand and the corresponding animals who have this brand for lunch
    static Map<FoodBrand, List<String>> animalFoodBrandChoices = new HashMap();

    /*
    The day starts with a message: “Day-N” (N from 1 to 10).
     */
    public static void dawnActivity(int currentDay) {
        System.out.println("Day-" + currentDay);
    }

    /*
    Every day each animal can unfriend one animal before lunchtime.
    If animal “A” unfriends animal“B”, “B” unfriends “A” automatically. App prints out all “unfriend” events.
    For example: “Alf and Bob are not friends anymore”.
     */
    public static void beforeLunchActivity(AnimalBehaviour animalFriendshipBehaviour,
                                           List<? extends Animal> yardAnimals) {
        //breaking of friendship
        yardAnimals.stream().forEach(animal -> animalFriendshipBehaviour.endRelationship(animal));
    }

    /*
    During lunchtime, the app prints out each animal’s favorite food grouped by the brand.
    For example: “Rex and Tom are eating Royal Canin”
     */
    public static void lunchActivity(List<? extends Animal> yardAnimals) {

        // This data never changes so this computation is done only once for the first time.
        if (animalFoodBrandChoices.isEmpty()) {
            Arrays.stream(FoodBrand.values()).forEach(foodBrand -> {
                animalFoodBrandChoices.put(foodBrand, new ArrayList<String>());
            });

            yardAnimals.stream().forEach(animal -> {
                FoodBrand favFoodBrand = ((Animal) animal).getFavFood();
                List<String> animalsHavingSameBrandFood = animalFoodBrandChoices.get(favFoodBrand);
                // add the animal to the list of animals having food with this brand
                animalsHavingSameBrandFood.add(((Animal) animal).getName());
                // add the list again back to the map
                animalFoodBrandChoices.put(favFoodBrand, animalsHavingSameBrandFood);
            });
        }

        Output.outputFoodChoices(animalFoodBrandChoices);

    }

    /*
    After lunch, each animal tries to establish a friendship with a random animal. Animal “A”, asks
    animal “B” to become friends. If “B” accepts friendship, “A” and “B” become friends. App prints
    out the result, for example:
    “Alf is asking Bob to be friends. Alf and Bob are friends now. (Or Bob doesn’t want to be
    friends)”
     */
    public static void afterLunchActivity(AnimalBehaviour animalFriendshipBehaviour, List<? extends Animal> yardAnimals) {
        //new friendships yay!
        yardAnimals.stream().forEach(animal -> animalFriendshipBehaviour.initiateRelationship(animal, yardAnimals));
    }

    public static void nightActivity(List<? extends Animal> yardAnimals) {
        Output.dailyRelationshipSummary(yardAnimals);
    }

}
