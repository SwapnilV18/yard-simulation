package com.swap.fun.world.inout;

import com.swap.fun.world.constants.DogBreed;
import com.swap.fun.world.constants.FoodBrand;
import com.swap.fun.world.living.animal.Animal;
import com.swap.fun.world.living.animal.bird.Chicken;
import com.swap.fun.world.living.animal.bird.Parrot;
import com.swap.fun.world.living.animal.bird.Rooster;
import com.swap.fun.world.living.animal.mammal.Cat;
import com.swap.fun.world.living.animal.mammal.Dog;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class InitialData {

    Map animalMap = new LinkedHashMap<String, Animal>();

    public List<Animal> loadAnimals() {

        animalMap.putAll(loadDogs());
        animalMap.putAll(loadCats());
        animalMap.putAll(loadChicken());
        animalMap.putAll(loadRooster());
        animalMap.putAll(loadParrot());

        setBestFriendsForever(animalMap);

        return new ArrayList<Animal>(animalMap.values());
    }


    private Map<String, Dog> loadDogs() {
        Map dogs = new LinkedHashMap<String, Dog>();

        dogs.put("Rex", new Dog("Rex", DogBreed.SHEPHERD, FoodBrand.ROYAL_CANIN));
        dogs.put("Max", new Dog("Max", DogBreed.SHEPHERD, FoodBrand.PURINA_ONE));
        dogs.put("Tom", new Dog("Tom", DogBreed.HUSKY, FoodBrand.ROYAL_CANIN));
        dogs.put("Jay", new Dog("Jay", DogBreed.HUSKY, FoodBrand.PURINA_ONE));

        return dogs;
    }

    private Map<String, Cat> loadCats() {
        Map cats = new LinkedHashMap<String, Cat>();

        cats.put("Zoe", new Cat("Zoe", FoodBrand.NINE_LIVES));
        cats.put("Ada", new Cat("Ada", FoodBrand.PURINA_FRISKIES));

        return cats;
    }

    private Map<String, Chicken> loadChicken() {
        Map chickens = new LinkedHashMap<String, Chicken>();

        chickens.put("Meg", new Chicken("Meg", FoodBrand.PURINA_LAYENA, true, 0.4f));
        chickens.put("Lis", new Chicken("Lis", FoodBrand.MANNA_PRO, true, 0.35f));
        chickens.put("Emi", new Chicken("Emi", FoodBrand.PURINA_LAYENA, false, 0.25f));
        chickens.put("Lua", new Chicken("Lua", FoodBrand.MANNA_PRO, false, 0.3f));

        return chickens;
    }

    private Map<String, Rooster> loadRooster() {
        Map<String, Rooster> roosters = new LinkedHashMap<String, Rooster>();

        roosters.put("Bob", new Rooster("Bob", FoodBrand.MANNA_PRO, 0.5f));

        return roosters;
    }

    private Map<String, Parrot> loadParrot() {
        Map parrots = new LinkedHashMap<String, Parrot>();

        parrots.put("Mac", new Parrot("Mac", FoodBrand.LAFEBER_ORIGINAL, true, 0.33f));
        parrots.put("Alf", new Parrot("Alf", FoodBrand.KAYTEE_FIESTA, false, 0.25f));

        return parrots;
    }

    private void setBestFriendsForever(Map<String, Animal> animalMap) {
        animalMap.get("Rex").setBestFriendForever(animalMap.get("Tom"));
        animalMap.get("Max").setBestFriendForever(animalMap.get("Jay"));
        animalMap.get("Tom").setBestFriendForever(animalMap.get("Rex"));
        animalMap.get("Jay").setBestFriendForever(animalMap.get("Max"));

        animalMap.get("Zoe").setBestFriendForever(animalMap.get("Ada"));
        animalMap.get("Ada").setBestFriendForever(animalMap.get("Zoe"));
        animalMap.get("Meg").setBestFriendForever(animalMap.get("Lis"));
        animalMap.get("Lis").setBestFriendForever(animalMap.get("Meg"));

        animalMap.get("Emi").setBestFriendForever(animalMap.get("Lua"));
        animalMap.get("Lua").setBestFriendForever(animalMap.get("Emi"));
        animalMap.get("Mac").setBestFriendForever(animalMap.get("Alf"));
        animalMap.get("Alf").setBestFriendForever(animalMap.get("Mac"));

    }

}
