package com.avaloq.diceassignment.model;

public class DiceBuilder {
    private int sides;

    public DiceBuilder withSides(final int sides) {
        this.sides = sides;
        return this;
    }

    public Dice build() {
        return new Dice(sides);
    }
}
