package com.swap.fun.world.constants;

/*
FoodBrand which provide the animals their food supply.
 */
public enum FoodBrand {

    ROYAL_CANIN("Royal Canin"),
    PURINA_ONE("Purina ONE"),
    NINE_LIVES("9Lives"),
    PURINA_FRISKIES("Purina Friskies"),
    PURINA_LAYENA("Purina Layena"),
    MANNA_PRO("Manna Pro"),
    LAFEBER_ORIGINAL("Lafeber Original"),
    KAYTEE_FIESTA("Kaytee Fiesta");

    private String name;

    FoodBrand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
