package com.swap.fun.world.mind.animal;

import com.swap.fun.world.living.Friend;
import com.swap.fun.world.living.LivingBeing;
import com.swap.fun.world.living.animal.Animal;
import com.swap.fun.world.social.FriendshipHandler;
import com.swap.fun.world.social.RelationshipHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class based on Mediator pattern having the logic of handling friendship behaviour between 2 entities(animals)
 *
 * @author - swapnil vargaonkar
 */
public class AnimalFriendshipBehaviour extends AnimalBehaviour {

    private Random r = new Random();

    public AnimalFriendshipBehaviour(RelationshipHandler relationshipHandler) {
        super(new FriendshipHandler());
    }

    public void initiateRelationship(LivingBeing animal, List<? extends Animal> yardAnimals) {

        boolean isNowGoingToTryMakingAFriend = isReadyForNewFriendShip(animal);
        if (!isNowGoingToTryMakingAFriend)
            return;

        List<Animal> strangers = new ArrayList<>();


        for (Animal yardAnimal : yardAnimals) {
            if (!animal.equals(yardAnimal)) { // check if it is not the same animal
                for (Friend friend : animal.getFriendList()) {
                    // check whether the yard animal is one amongst the friends.
                    if (friend.getBeing().equals(yardAnimal)) {
                        break;
                    }
                }
                strangers.add(yardAnimal);
            }
        }

        //pick a random stranger as prospective friend

        int addFriendProposalIndex = r.nextInt(strangers.size());
        Animal prospectiveFriend = strangers.get(addFriendProposalIndex);
        System.out.print(animal.getName() + " is asking " + prospectiveFriend.getName() + " to become friends. ");

        boolean isNowGoingToAcceptFriendRequest = isReadyForNewFriendShip(prospectiveFriend);

        if (isNowGoingToAcceptFriendRequest) {
            System.out.println(animal.getName() + " and " + prospectiveFriend.getName() + " are friends now.");
            getRelationshipHandler().on(animal, prospectiveFriend);
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

        boolean isNowGoingToLoseFriend = r.nextInt(100) <= loseFriendProbablity;
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

    private boolean isReadyForNewFriendShip(LivingBeing animal){
        int makeNewFriendProbablity = 0;
        int numberOfFrnds = animal.getFriendList().size();

        if (numberOfFrnds >= 3) {
            makeNewFriendProbablity = 10;
        } else if (numberOfFrnds <= 2) {
            makeNewFriendProbablity = 90;
        }
       return (r.nextInt(100) <= makeNewFriendProbablity);
    }
}
