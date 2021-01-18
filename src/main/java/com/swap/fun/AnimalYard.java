package com.swap.fun;

import com.swap.fun.world.mind.animal.AnimalFriendshipBehaviour;
import com.swap.fun.world.spacetime.AnimalYardSpaceTimeProgression;
import com.swap.fun.world.spacetime.DayState;

public class AnimalYard {

    public static void main(String[] args) {
        AnimalYardSpaceTimeProgression animalYardSpaceTimeProgression = new AnimalYardSpaceTimeProgression(1, DayState.DAWN,10,new AnimalFriendshipBehaviour());
        animalYardSpaceTimeProgression.bigBang();
    }
}
