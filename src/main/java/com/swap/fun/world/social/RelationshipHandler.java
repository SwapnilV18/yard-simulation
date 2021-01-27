package com.swap.fun.world.social;

import com.swap.fun.world.living.LivingBeing;

public interface RelationshipHandler {

    public void on(LivingBeing being1, LivingBeing being2);

    public void off(LivingBeing being1, LivingBeing being2);
}
