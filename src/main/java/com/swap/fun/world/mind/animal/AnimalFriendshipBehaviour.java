package com.swap.fun.world.mind.animal;

import com.swap.fun.world.life.LivingBeing;
import com.swap.fun.world.social.Friendship;
import com.swap.fun.world.social.Relationship;

/**
 * Mediator pattern having the logic
 @author - swapnil vargaonkar
 */
public class AnimalFriendshipBehaviour extends AnimalBehaviour {

    private static Relationship friendship = new Friendship();

    public void initiateFriendship(LivingBeing being1, LivingBeing being2){
        initiateRelationship(friendship,being1,being2);
    }

    public void endFriendship(LivingBeing being1, LivingBeing being2){
        endRelationship(friendship,being1,being2);
    }

    protected void initiateRelationship(Relationship relationship, LivingBeing being1, LivingBeing being2) {
        //Todo: Logic of friendship rule between sender and receiver
    }

    protected void endRelationship(Relationship relationship, LivingBeing being1, LivingBeing being2) {
    //Todo: Logic of friendship rule between sender and receiver
    }
}
