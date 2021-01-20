package com.swap.fun.world.social;

import com.swap.fun.world.living.Friend;
import com.swap.fun.world.living.LivingBeing;

/*
There could be similar classes like one sided friendship where only one side sets the other as a friend
but the other adds the person in a acquaintance list.
 */
public class FriendshipHandler extends RelationshipHandler {

    public void on(LivingBeing being1, LivingBeing being2) {
        being1.getFriendList().add(new Friend(being2, false));
        being2.getFriendList().add(new Friend(being1, false));

    }

    public void off(LivingBeing being1, LivingBeing being2) {
        //bestFriendForever are never removed so we can send the key directly with bestFriendForever set to false.
        being1.getFriendList().remove(new Friend(being2, false));
        being2.getFriendList().remove(new Friend(being1, false));

    }
}
