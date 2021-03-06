package com.swap.fun.world.spacetime;

import com.swap.fun.world.constants.DayState;
import com.swap.fun.world.inout.InitialData;
import com.swap.fun.world.living.animal.Animal;
import com.swap.fun.world.mind.animal.AnimalBehaviour;

import java.util.List;
import java.util.logging.Logger;

/**
 * Animals of Yard have their own simulation world. They extend through a generic spaceTimeProgression mechanism. This class implements state design pattern to manage state of time
 * ad interaction of the world inside it.
 *
 * @author - swapnil vargaonkar
 */
public class AnimalYardSpaceTimeProgression extends SpaceTimeProgression {

    Logger logger = Logger.getLogger(AnimalYardSpaceTimeProgression.class.getName());

    private int currentDay;
    private DayState dayState;
    private int doomsDay;
    private AnimalBehaviour animalFriendshipBehaviour;
    private List<? extends Animal> yardAnimals;
    private boolean apocalypse;

    public AnimalYardSpaceTimeProgression(int currentDay, DayState dayState, int doomsDay, AnimalBehaviour animalFriendshipBehaviour) {
        this.currentDay = currentDay;
        this.dayState = dayState;
        this.doomsDay = doomsDay;
        this.animalFriendshipBehaviour = animalFriendshipBehaviour;
    }

    public void introduceLivingBeings() {

        yardAnimals = new InitialData().loadAnimals();
    }

    public void spinTime() {

        do {
            switch (dayState) {
                case DAWN: {
                    Activities.dawnActivity(currentDay);
                    dayState = DayState.BEFORE_LUNCH;
                    break;
                }
                case BEFORE_LUNCH: {
                    Activities.beforeLunchActivity(animalFriendshipBehaviour, yardAnimals);
                    dayState = DayState.LUNCH;
                    break;
                }
                case LUNCH: {
                    Activities.lunchActivity(yardAnimals);
                    dayState = DayState.AFTER_LUNCH;
                    break;
                }
                case AFTER_LUNCH: {
                    Activities.afterLunchActivity(animalFriendshipBehaviour, yardAnimals);
                    dayState = DayState.NIGHT;
                    break;
                }
                case NIGHT: {
                    Activities.nightActivity(yardAnimals);
                    if (currentDay < doomsDay) {
                        currentDay++;
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (currentDay == doomsDay && dayState == DayState.NIGHT) {
                            apocalypse = true;//no next day.
                        } else {
                            dayState = DayState.DAWN;
                        }
                    }
                    break;
                }
            }
        } while (!apocalypse);

    }

    protected void destroy() {
        // memory clean up wherever necessary.
    }
}
