package com.avaloq.diceassignment.model;

public class SimulationResult {
    private Long simulationCount;
    private Long rollsCount;

    public SimulationResult() {}

    public SimulationResult(final Long simulationCount, final Long rollsCount) {
        this.simulationCount = simulationCount;
        this.rollsCount = rollsCount;
    }

    public Long getSimulationCount() {
        return simulationCount;
    }
    public void setSimulationCount(final Long simulationCount) {
        this.simulationCount = simulationCount;
    }
    public Long getRollsCount() {
        return rollsCount;
    }
    public void setRollsCount(final Long rollsCount) {
        this.rollsCount = rollsCount;
    }

    
}
