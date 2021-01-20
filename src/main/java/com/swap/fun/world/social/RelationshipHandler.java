package com.swap.fun.world.social;

import com.swap.fun.world.living.LivingBeing;

public abstract class RelationshipHandler {

    public abstract void on(LivingBeing being1, LivingBeing being2);

    public abstract void off(LivingBeing being1, LivingBeing being2);
}
