package com.swap.fun.world.inout;

import com.swap.fun.world.constants.FoodBrand;
import com.swap.fun.world.living.animal.Animal;

import java.util.List;
import java.util.Map;

public class Output {

    final private static String summaryHeaderFooterBoundary = "------";
    final private static String commaSeperator = ", ";
    final private static String andSeperator = " and ";
    final private static String areEatingText = " are eating ";
    final private static String isEatingText = " is eating ";
    final private static String fullStop = ".";
    final private static String summarySeperatorStart = "| ";
    final private static String summarySeperatorEnd = " | ";
    final private static String summaryBlankEntry = "   ";
    final private static String summaryNAEntry = " \\ ";
    final private static String summaryFriendEntry = " X ";


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
                stringBuilder.append(commaSeperator).append(animalNames.get(nameCount));
            }
            // append last animal with an and seperator
            stringBuilder.append(andSeperator).append(animalNames.get(animalNames.size() - 1));

        } else if (animalNames.size() == 2) {
            stringBuilder.append(commaSeperator).append(animalNames.get(1));

        } else {
            stringBuilder.append(isEatingText).append(brand).append(fullStop);
            return stringBuilder.toString();
        }
        stringBuilder.append(areEatingText).append(brand).append(fullStop);
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
        headerStringBuilder.append(summarySeperatorStart).append(summaryBlankEntry).append(summarySeperatorEnd);
        yardAnimals.forEach(animal -> {
            headerStringBuilder.append(animal.getName()).append(summarySeperatorEnd);
        });
        return headerStringBuilder.toString();
    }

    public static String printBody(List<? extends Animal> yardAnimals) {
        StringBuilder body = new StringBuilder();
        for (int countAnimal = 0; countAnimal < yardAnimals.size(); countAnimal++) {
            Animal animal = yardAnimals.get(countAnimal);
            body.append(summarySeperatorStart).append(animal.getName()).append(summarySeperatorEnd);
            yardAnimals.forEach(friend -> {
                if (animal.equals(friend)) {
                    body.append(summaryNAEntry);
                } else {//check if this guy is a friend or not to the animal
                    if (animal.isFriend(friend)) {
                        body.append(summaryFriendEntry);
                    } else {
                        body.append(summaryBlankEntry);
                    }
                }
                body.append(summarySeperatorEnd);
            });
            if (countAnimal<yardAnimals.size()-1)
                body.append("\n");
        };
        return body.toString();
    }

    public static String printHeaderOrFooterBorder(List<? extends Animal> yardAnimals) {
        StringBuilder headerStringBuilder = new StringBuilder(" ");//initial space for indentation
        // later loop this to match the count of animals
        for (int count = 0; count <= yardAnimals.size(); count++)
            headerStringBuilder.append(summaryHeaderFooterBoundary);
        return headerStringBuilder.toString();
    }
}
