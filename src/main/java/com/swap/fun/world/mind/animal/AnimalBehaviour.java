package com.swap.fun.world.mind.animal;

import com.swap.fun.world.life.LivingBeing;
import com.swap.fun.world.social.Relationship;

/**
 * This class states the behaviour traits shown by animals regarding their relationships and
 * interactions with the rest of the world.
 * This will be based on mediator design pattern which is a behavioural pattern and it will mediate between 2 living being
 * entities and define how a generic animal behaviour instincts will decide the outcome of their relationship.
 @author - swapnil vargaonkar
 */
public abstract class AnimalBehaviour {

    protected abstract void initiateRelationship(Relationship relationship,LivingBeing being1, LivingBeing being2);

    protected abstract void endRelationship(Relationship relationship, LivingBeing being1, LivingBeing being2);


}
