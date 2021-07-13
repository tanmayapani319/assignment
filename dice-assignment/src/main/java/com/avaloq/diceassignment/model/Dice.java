package com.avaloq.diceassignment.model;

public class Dice {
    private final int sides;

    public Dice(final int slides) {
        this.sides = slides;
    }

    public int getSides() {
        return sides;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + sides;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dice other = (Dice) obj;
        if (sides != other.sides)
            return false;
        return true;
    }



    
}
