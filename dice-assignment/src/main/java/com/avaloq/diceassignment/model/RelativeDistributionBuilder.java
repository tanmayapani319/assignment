package com.avaloq.diceassignment.model;

public class RelativeDistributionBuilder {
    private String relativeDistribution;
    private int totalRolls;
    private int sum;

    public RelativeDistributionBuilder withRelativeDistribution(final String relativeDistribution) {
        this.relativeDistribution = relativeDistribution;
        return this;
    }

    public RelativeDistributionBuilder withTotalRolls(final int totalRolls) {
        this.totalRolls = totalRolls;
        return this;
    }

    public RelativeDistributionBuilder withSum(final int sum) {
        this.sum = sum;
        return this;
    }

    public RelativeDistribution build() {
        return new RelativeDistribution(relativeDistribution, totalRolls, sum);
    }
}
