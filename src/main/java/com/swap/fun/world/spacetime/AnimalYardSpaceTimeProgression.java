package com.swap.fun.world.spacetime;

import com.swap.fun.world.life.LivingBeing;
import com.swap.fun.world.mind.animal.AnimalBehaviour;
import com.swap.fun.world.mind.animal.AnimalFriendshipBehaviour;

import java.util.ArrayList;
import java.util.List;

/**
 * Animals of Yard have their own simulation world. They extend through a generic spaceTimeProgression mechanism. This class implements state design pattern to manage state of time
 * ad interaction of the world inside it.
 *
 * @author - swapnil vargaonkar
 */
public class AnimalYardSpaceTimeProgression extends SpaceTimeProgression {


    private int currentDay;
    private DayState dayState;
    private int doomsDay;
    private AnimalBehaviour animalFriendshipBehaviour;

    public AnimalYardSpaceTimeProgression(int currentDay, DayState dayState, int doomsDay, AnimalBehaviour animalFriendshipBehaviour) {
        this.currentDay = currentDay;
        this.dayState = dayState;
        this.doomsDay = doomsDay;
        this.animalFriendshipBehaviour = animalFriendshipBehaviour;
    }

    public void introduceLivingBeings() {
        List<LivingBeing> yardAnimals = new ArrayList<LivingBeing>();
    }

    public void initiateBehaviouralTraits() {
        animalFriendshipBehaviour = new AnimalFriendshipBehaviour();
    }

    public void spinTime() {

        switch (dayState) {
            case DAWN:
                //TODO : Day-n message
                dayState = DayState.BEFORE_LUNCH;
                break;
            case BEFORE_LUNCH:
                //TODO : break friendship
                dayState = DayState.LUNCH;
                break;
            case LUNCH:
                //TODO : print brands.
                dayState = DayState.AFTER_LUNCH;
                break;
            case AFTER_LUNCH:
                //TODO : make freindship
                dayState = DayState.NIGHT;
                break;
            case NIGHT:
                //TODO : print friendship matrix.
                if (currentDay < doomsDay) {
                    currentDay++;
                    dayState = DayState.DAWN;
                }
                break;
        }

    }

    public void summarize() {

    }

    protected void destroy() {

    }
}
