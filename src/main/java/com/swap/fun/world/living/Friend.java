package com.swap.fun.world.living;

import java.util.Objects;

public class Friend {

    private LivingBeing being;
    private boolean bestFriendForever;

    public Friend(LivingBeing being, boolean bestFriendForever) {
        this.being = being;
        this.bestFriendForever = bestFriendForever;
    }

    public LivingBeing getBeing() {
        return being;
    }

    public void setBeing(LivingBeing being) {
        this.being = being;
    }

    public boolean isBestFriendForever() {
        return bestFriendForever;
    }

    public void setBestFriendForever(boolean bestFriendForever) {
        this.bestFriendForever = bestFriendForever;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friend friend = (Friend) o;
        return isBestFriendForever() == friend.isBestFriendForever() &&
                Objects.equals(getBeing(), friend.getBeing());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBeing(), isBestFriendForever());
    }
}
