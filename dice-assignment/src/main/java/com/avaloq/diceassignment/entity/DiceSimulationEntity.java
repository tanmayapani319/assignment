package com.avaloq.diceassignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_DICE_SIMULATION")
public class DiceSimulationEntity {

    @Id 
    @GeneratedValue 
    private Long id;

    @Column(name="dice_count")
    private int diceCount;

    @Column(name="dice_sides")
    private int diceSides;
    
    @Column(name="total_rolls")
    private int totalSimulations;

    DiceSimulationEntity() {}

    public DiceSimulationEntity(final int diceCount, final int diceSides, final int totalSimulations) {
        this.diceCount = diceCount;
        this.diceSides = diceSides;
        this.totalSimulations = totalSimulations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDiceCount() {
        return diceCount;
    }

    public void setDiceCount(int diceCount) {
        this.diceCount = diceCount;
    }

    public int getDiceSides() {
        return diceSides;
    }

    public void setDiceSides(int diceSides) {
        this.diceSides = diceSides;
    }

    public int getTotalSimulations() {
        return totalSimulations;
    }

    public void setTotalSimulations(int totalSimulations) {
        this.totalSimulations = totalSimulations;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + diceCount;
        result = prime * result + diceSides;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + totalSimulations;
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
        DiceSimulationEntity other = (DiceSimulationEntity) obj;
        if (diceCount != other.diceCount)
            return false;
        if (diceSides != other.diceSides)
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (totalSimulations != other.totalSimulations)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DiceSimulationEntity [diceCount=" + diceCount + ", diceSides=" + diceSides + ", id=" + id
                + ", totalSimulations=" + totalSimulations + "]";
    }

    
    
}
