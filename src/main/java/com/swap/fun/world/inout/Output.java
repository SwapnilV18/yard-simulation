package com.swap.fun.world.inout;

import com.swap.fun.world.constants.FoodBrand;
import com.swap.fun.world.living.animal.Animal;

import java.util.List;
import java.util.Map;

public class Output {

    private Output() {
        // static util class, not supposed to be instantiated-
    }

    private static final String SUMMARY_HEADERFOOTER_BOUNDARY = "------";
    private static final String COMMA_SEPERATOR = ", ";
    private static final String AND_SEPERATOR = " and ";
    private static final String ARE_EATING = " are eating ";
    private static final String IS_EATING = " is eating ";
    private static final String FULL_STOP = ".";
    private static final String SUMMARY_SEPERATOR_START = "| ";
    private static final String SUMMARY_SEPERATOR_END = " | ";
    private static final String SUMMARY_BLANK_ENTRY = "   ";
    private static final String SUMMARY_NA_ENTRY = " \\ ";
    private static final String SUMMARY_FRIEND_ENTRY = " X ";


    public static void outputFoodChoices(Map<FoodBrand, List<String>> animalFoodBrandChoices) {
        animalFoodBrandChoices.entrySet().stream().forEach(foodBrand -> {
            List<String> animalNames = animalFoodBrandChoices.get(foodBrand.getKey());
            System.out.println(lunchOutput(foodBrand.getKey().getName(), animalNames));
        });
    }

    /*
    This method is used to compile the output string for lunch and it uses string builder for
    avoiding too many string objects floating around in the heap.
     */
    private static String lunchOutput(String brand, List<String> animalNames) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(animalNames.get(0));
        if (animalNames.size() > 2) {
            for (int nameCount = 1; nameCount < animalNames.size() - 1; nameCount++) {
                stringBuilder.append(COMMA_SEPERATOR).append(animalNames.get(nameCount));
            }
            // append last animal with an and seperator
            stringBuilder.append(AND_SEPERATOR).append(animalNames.get(animalNames.size() - 1));

        } else if (animalNames.size() == 2) {
            stringBuilder.append(COMMA_SEPERATOR).append(animalNames.get(1));

        } else {
            stringBuilder.append(IS_EATING).append(brand).append(FULL_STOP);
            return stringBuilder.toString();
        }
        stringBuilder.append(ARE_EATING).append(brand).append(FULL_STOP);
        return stringBuilder.toString();
    }

    public static void dailyRelationshipSummary(List<? extends Animal> yardAnimals) {
        System.out.println(printHeaderOrFooterBorder(yardAnimals));
        System.out.println(printHeaderColumn(yardAnimals));

        System.out.println(printBody(yardAnimals));
        System.out.println(printHeaderOrFooterBorder(yardAnimals));
    }

    public static String printHeaderColumn(List<? extends Animal> yardAnimals) {
        StringBuilder headerStringBuilder = new StringBuilder();//initial space for indentation
        headerStringBuilder.append(SUMMARY_SEPERATOR_START).append(SUMMARY_BLANK_ENTRY).append(SUMMARY_SEPERATOR_END);
        yardAnimals.forEach(animal -> {
            headerStringBuilder.append(animal.getName()).append(SUMMARY_SEPERATOR_END);
        });
        return headerStringBuilder.toString();
    }

    public static String printBody(List<? extends Animal> yardAnimals) {
        StringBuilder body = new StringBuilder();
        for (int countAnimal = 0; countAnimal < yardAnimals.size(); countAnimal++) {
            Animal animal = yardAnimals.get(countAnimal);
            body.append(SUMMARY_SEPERATOR_START).append(animal.getName()).append(SUMMARY_SEPERATOR_END);
            yardAnimals.forEach(friend -> {
                if (animal.equals(friend)) {
                    body.append(SUMMARY_NA_ENTRY);
                } else {//check if this guy is a friend or not to the animal
                    if (animal.isFriend(friend)) {
                        body.append(SUMMARY_FRIEND_ENTRY);
                    } else {
                        body.append(SUMMARY_BLANK_ENTRY);
                    }
                }
                body.append(SUMMARY_SEPERATOR_END);
            });
            if (countAnimal < yardAnimals.size() - 1)
                body.append("\n");
        }
        ;
        return body.toString();
    }

    public static String printHeaderOrFooterBorder(List<? extends Animal> yardAnimals) {
        StringBuilder headerStringBuilder = new StringBuilder(" ");//initial space for indentation
        // later loop this to match the count of animals
        for (int count = 0; count <= yardAnimals.size(); count++)
            headerStringBuilder.append(SUMMARY_HEADERFOOTER_BOUNDARY);
        return headerStringBuilder.toString();
    }
}
