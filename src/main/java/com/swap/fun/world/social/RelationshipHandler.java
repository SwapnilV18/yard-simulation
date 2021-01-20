package com.swap.fun.world.social;

import com.swap.fun.world.living.LivingBeing;

public interface RelationshipHandler {

    public abstract void on(LivingBeing being1, LivingBeing being2);

    public abstract void off(LivingBeing being1, LivingBeing being2);
}
