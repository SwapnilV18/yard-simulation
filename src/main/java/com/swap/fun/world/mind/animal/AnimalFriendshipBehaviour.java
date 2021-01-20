package com.swap.fun.world.mind.animal;

import com.swap.fun.world.living.Friend;
import com.swap.fun.world.living.LivingBeing;
import com.swap.fun.world.living.animal.Animal;
import com.swap.fun.world.social.FriendshipHandler;
import com.swap.fun.world.social.RelationshipHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Class based on Mediator pattern having the logic of handling friendship behaviour between 2 entities(animals)
 *
 * @author - swapnil vargaonkar
 */
public class AnimalFriendshipBehaviour extends AnimalBehaviour {

    public AnimalFriendshipBehaviour(RelationshipHandler relationshipHandler) {
        super(new FriendshipHandler());
    }

    public void initiateRelationship(LivingBeing animal1, List<? extends Animal> yardAnimals) {
        int makeNewFriendProbablity = 0;
        int numberOfFrnds = animal1.getFriendList().size();

        if (numberOfFrnds >= 3) {
            makeNewFriendProbablity = 10;
        } else if (numberOfFrnds <= 2) {
            makeNewFriendProbablity = 90;
        }
        boolean isNowGoingToTryMakingAFriend = (Math.random() * 100 <= makeNewFriendProbablity);
        if (!isNowGoingToTryMakingAFriend)
            return;

        List<Animal> strangers = new ArrayList<Animal>();

        outer:
        for (Animal animal : yardAnimals) {
            if (!animal1.equals(animal)) { // check if it is not the same animal
                for (Friend friend : animal1.getFriendList()) {
                    // check whether the yard animal is one amongst the friends.
                    if (friend.getBeing().equals(animal)) {
                        continue outer;
                    }
                }
                strangers.add(animal);
            }
        }

        int addFriendProposalIndex = (int) (Math.random() * strangers.size());
        Animal prospectiveFriend = strangers.get(addFriendProposalIndex);
        System.out.print(animal1.getName() + " is asking " + prospectiveFriend.getName() + " to become friends. ");
        numberOfFrnds = prospectiveFriend.getFriendList().size();

        if (numberOfFrnds >= 3) {
            makeNewFriendProbablity = 10;
        } else if (numberOfFrnds <= 2) {
            makeNewFriendProbablity = 90;
        }
        boolean isNowGoingToAcceptFriendRequest = Math.random() * 100 <= makeNewFriendProbablity;
        if (isNowGoingToAcceptFriendRequest) {
            System.out.println(animal1.getName() + " and " + prospectiveFriend.getName() + " are friends now.");
            getRelationshipHandler().on(animal1, prospectiveFriend);
        } else
            System.out.println(prospectiveFriend.getName() + " doesn't want to be friends.");

    }


    /*
     Relation ship ending can be a solely done by a single person. as more and more frnds grow ,
     the probablity of ending few relationships keeps increasing as seen in real life.
    */

    public void endRelationship(LivingBeing being) {
        int loseFriendProbablity = 0;
        int numberOfFrnds = being.getFriendList().size();

        if (numberOfFrnds >= 3)
            loseFriendProbablity = 90;
        else if (numberOfFrnds <= 2)
            loseFriendProbablity = 10;

        boolean isNowGoingToLoseFriend = (Math.random() * 100 <= loseFriendProbablity);
        if (isNowGoingToLoseFriend) {
            //which friends ties will break?
            boolean friendshipEnded = false;
            int friendCounter = 1;// we need minimum one friend to be present.
            while (!friendshipEnded && friendCounter <= numberOfFrnds) {
                Friend newestFriend = being.getFriendList().get(numberOfFrnds - friendCounter++);
                if (!newestFriend.isBestFriendForever()) {
                    being.getFriendList().remove(newestFriend);
                    //pass on the 2 beings to the relationship handler.
                    getRelationshipHandler().off(being, newestFriend.getBeing());
                    friendshipEnded = true;
                    System.out.println(being.getName() + " and " + newestFriend.getBeing().getName() + " are not friends anymore.");
                }
            }
        }
    }
}
