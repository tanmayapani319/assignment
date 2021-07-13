package com.avaloq.diceassignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_SUM_OCCURRENCES")
public class ResultsEntity {

    @Id 
    @GeneratedValue 
    private Long id;
    
    @Column(name="sum")
    private int sum;

    @Column(name="occurrences")
    private int occurrences;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diceSimulationEntity_id")
    private DiceSimulationEntity diceSimulationEntity;

    public ResultsEntity() {}

    public ResultsEntity(final int sum, final int occurrences) {
        this.sum = sum;
        this.occurrences = occurrences;
    }

    public int getSum() {
        return sum;
    }
    public void setSum(final int sum) {
        this.sum = sum;
    }
    public int getOccurrences() {
        return occurrences;
    }
    public void setOccurrences(final int occurrences) {
        this.occurrences = occurrences;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public DiceSimulationEntity getDiceSimulationEntity() {
        return diceSimulationEntity;
    }
    public void setDiceSimulationEntity(DiceSimulationEntity diceSimulationEntity) {
        this.diceSimulationEntity = diceSimulationEntity;
    }

    
    
}
