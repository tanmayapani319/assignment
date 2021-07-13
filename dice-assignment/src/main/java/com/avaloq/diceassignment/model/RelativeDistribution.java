package com.avaloq.diceassignment.model;

public class RelativeDistribution {
    private String relativeDistribution;
    private int totalRolls;
    private int sum;

    public RelativeDistribution(final String relativeDistribution,
    final int totalRolls, final int sum) {
        this.relativeDistribution = relativeDistribution;
        this.totalRolls = totalRolls;
        this.sum = sum;
    }
    
    public String getRelativeDistribution() {
        return relativeDistribution;
    }
    
    public int getTotalRolls() {
        return totalRolls;
    }
    
    public int getSum() {
        return sum;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((relativeDistribution == null) ? 0 : relativeDistribution.hashCode());
        result = prime * result + sum;
        result = prime * result + totalRolls;
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
        RelativeDistribution other = (RelativeDistribution) obj;
        if (relativeDistribution == null) {
            if (other.relativeDistribution != null)
                return false;
        } else if (!relativeDistribution.equals(other.relativeDistribution))
            return false;
        if (sum != other.sum)
            return false;
        if (totalRolls != other.totalRolls)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "RelativeDistribution [relativeDistribution=" + relativeDistribution + ", sum=" + sum + ", totalRolls="
                + totalRolls + "]";
    }
    

    
}
