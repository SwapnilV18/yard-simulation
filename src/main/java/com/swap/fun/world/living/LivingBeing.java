package com.swap.fun.world.living;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class LivingBeing {

    protected String name;

    protected List<Friend> friendList = new ArrayList<>();

    public LivingBeing() {
    }

    public LivingBeing(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Friend> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<Friend> friendList) {
        this.friendList = friendList;
    }

    public boolean isFriend(LivingBeing being) {
        return getFriendList().stream().anyMatch(friend -> friend.getBeing().equals(being));
    }

    public void addFriend(Friend friend) {
        this.friendList.add(friend);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LivingBeing that = (LivingBeing) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
