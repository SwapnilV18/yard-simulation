package com.swap.fun.world.mind.animal;

import com.swap.fun.world.living.LivingBeing;
import com.swap.fun.world.living.animal.Animal;
import com.swap.fun.world.social.RelationshipHandler;

import java.util.List;

/**
 * This class states the behaviour traits shown by animals regarding their relationships and
 * interactions with the rest of the world.
 * This will be based on mediator design pattern which is a behavioural pattern and it will mediate between 2 living being
 * entities and define how a generic animal behaviour instincts will decide the outcome of their relationshipHandler.
 *
 * @author - swapnil vargaonkar
 */
public abstract class AnimalBehaviour {

    private RelationshipHandler relationshipHandler;

    public AnimalBehaviour() {
    }

    public AnimalBehaviour(RelationshipHandler relationshipHandler) {
        this.relationshipHandler = relationshipHandler;
    }

    public RelationshipHandler getRelationshipHandler() {
        return relationshipHandler;
    }

    public void setRelationshipHandler(RelationshipHandler relationshipHandler) {
        this.relationshipHandler = relationshipHandler;
    }

    public abstract void initiateRelationship(LivingBeing being1, List<? extends Animal> yardAnimals);

    public abstract void endRelationship(LivingBeing being1);


}
