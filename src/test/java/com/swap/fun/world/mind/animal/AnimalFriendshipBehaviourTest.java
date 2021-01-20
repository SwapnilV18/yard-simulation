package com.swap.fun.world.mind.animal;

import com.swap.fun.world.constants.DogBreed;
import com.swap.fun.world.constants.FoodBrand;
import com.swap.fun.world.living.Friend;
import com.swap.fun.world.living.animal.bird.Parrot;
import com.swap.fun.world.living.animal.mammal.Cat;
import com.swap.fun.world.living.animal.mammal.Dog;
import com.swap.fun.world.social.FriendshipHandler;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class AnimalFriendshipBehaviourTest {

    static Dog pup1, pup2;
    static Cat kitten1;
    static Parrot par1;
    AnimalBehaviour animalFriendshipBehaviour = new AnimalFriendshipBehaviour(new FriendshipHandler());
    int loopCount = 100000;


    @BeforeAll
    public static void init() {
        pup1 = new Dog("ABC", DogBreed.HUSKY, FoodBrand.PURINA_LAYENA);
        pup2 = new Dog("XYZ", DogBreed.SHEPHERD, FoodBrand.PURINA_ONE);
        par1 = new Parrot("PAR", FoodBrand.PURINA_LAYENA, true, 0.4f);
        kitten1 = new Cat("Jan", FoodBrand.MANNA_PRO);

        pup1.setBestFriendForever(pup2);
        // set kitten with 3 friends.
        kitten1.setBestFriendForever(pup1);
        kitten1.addFriend(new Friend(pup2, false));
        kitten1.addFriend(new Friend(par1, false));
    }

    @Description("This test will check the readiness (probability) for making new friendship for people having less " +
            "than 2 friends")
    @Test
    public void testIsReadyForNewFriendShipFriendsLessThan2Test() {
        boolean isReadyForNewFriendship;
        int readyCount = 0;
        System.out.println("pup1"+pup1);
        for (int i = 0; i < loopCount; i++) {
            isReadyForNewFriendship = animalFriendshipBehaviour.isReadyForNewFriendShip(pup1);
            if (isReadyForNewFriendship)
                readyCount++;
        }
        double percentageOfReadinessToMakeFriendship = ((100d * readyCount) / loopCount);
        Assertions.assertTrue(Math.abs(90 - percentageOfReadinessToMakeFriendship) <= 0.5, "The probablity of new friendship " +
                "readiness should be approx to 90% for animals with less than 2 friends but it is " + percentageOfReadinessToMakeFriendship);

    }

    @Description("This test will check the readiness (probability) for breaking friendship for people having less " +
            "than 2 friends")
    @Test
    public void testIsReadyForBreakingFriendShipFriendsLessThan2Test() {
        boolean isReadyForBreakingFriend;
        int readyCount = 0;
        for (int i = 0; i < loopCount; i++) {
            isReadyForBreakingFriend = animalFriendshipBehaviour.isReadyForBreakingFriendShip(pup1);
            if (isReadyForBreakingFriend)
                readyCount++;
        }
        double percentageOfReadinessToBreakFriendship = ((100d * readyCount) / loopCount);
        Assertions.assertTrue(Math.abs(10 - percentageOfReadinessToBreakFriendship) <= 0.5, "The probablity of breaking " +
                "friendship should be approx to 10% for animals with less than 2 friends but it is " + percentageOfReadinessToBreakFriendship);

    }

    @Description("This test will check the readiness (probability) for making new friendship for people having more " +
            "than 2 friends")
    @Test
    public void testIsReadyForNewFriendShipFriendsMoreThan2Test() {
        boolean isReadyForNewFriendship;
        int readyCount = 0;
        for (int i = 0; i < loopCount; i++) {
            isReadyForNewFriendship = animalFriendshipBehaviour.isReadyForNewFriendShip(kitten1);
            if (isReadyForNewFriendship)
                readyCount++;
        }
        double percentageOfReadinessToMakeFriendship = ((100d * readyCount) / loopCount);
        Assertions.assertTrue(Math.abs(10 - percentageOfReadinessToMakeFriendship) <= 0.5, "The probablity of new " +
                "friendship " +
                "readiness should be approx to 10% for animals with more than 2 friends but it is " + percentageOfReadinessToMakeFriendship);

    }

    @Description("This test will check the readiness (probability) for breaking friendship for people having more " +
            "than 2 friends")
    @Test
    public void testIsReadyForBreakingFriendShipFriendsMoreThan2Test() {
        boolean isReadyForBreakingFriend;
        int readyCount = 0;
        for (int i = 0; i < loopCount; i++) {
            isReadyForBreakingFriend = animalFriendshipBehaviour.isReadyForBreakingFriendShip(kitten1);
            if (isReadyForBreakingFriend)
                readyCount++;
        }
        double percentageOfReadinessToBreakFriendship = ((100d * readyCount) / loopCount);
        Assertions.assertTrue(Math.abs(90 - percentageOfReadinessToBreakFriendship) <= 0.5, "The probablity of breaking " +
                "friendship should be approx to 90% for animals with more than 2 friends but it is " + percentageOfReadinessToBreakFriendship);

    }
}
