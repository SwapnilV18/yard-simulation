package com.swap.fun.world.spacetime;

/**
 * This class is designed based on a template design pattern which will define certain steps to fullfill an algorithm.
 * Here we create templates for normal lifecycle events when spacetime progresses in a virtual world.
 * @author - swapnil vargaonkar
 */
public abstract class SpaceTimeProgression {

    /*
    the start of the simulation world
     */
    public final void bigBang() {
        introduceLivingBeings();
        initiateBehaviouralTraits();
        spinTime();
        // the bigbang leads to a apocalypse at the end of the world.
        apocalypse();
    }

    /*
    the end of the simulation world
     */
    private final void apocalypse() {
        destroy();
    }

    /*
    The living beings are introduced who will participate in the simulation.
     */
    public abstract void introduceLivingBeings();

    /*
    The behaviour patterns of living beings are stated here.
     */
    public abstract void initiateBehaviouralTraits();

    /*
    This will make the spacetime to start rolling an the simulation world will come to life
     */
    public abstract void spinTime();

    /*
    The state of the world at a given spacetime
     */
    public abstract void summarize();

    /*
    cleaning up the simulation world
     */
    protected abstract void destroy();

}
