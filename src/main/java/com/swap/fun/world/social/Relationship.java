package com.swap.fun.world.social;

import com.swap.fun.world.life.LivingBeing;

public abstract class Relationship {

    protected abstract void on(LivingBeing being1, LivingBeing being2);

    protected abstract void off(LivingBeing being1, LivingBeing being2);
}
