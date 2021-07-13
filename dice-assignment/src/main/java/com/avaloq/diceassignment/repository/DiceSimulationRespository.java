package com.avaloq.diceassignment.repository;

import java.util.List;

import com.avaloq.diceassignment.entity.DiceSimulationEntity;
import com.avaloq.diceassignment.model.SimulationResult;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DiceSimulationRespository extends JpaRepository<DiceSimulationEntity, Long> {

    @Query("SELECT new com.avaloq.diceassignment.model.SimulationResult(COUNT(a.diceCount), SUM(a.totalRolls)) "
  + "FROM DiceSimulationEntity AS a GROUP BY (a.diceCount, a.diceSides)")
  List<SimulationResult> countTotalSimulationsByDiceNumbersAndSides();

  List<DiceSimulationEntity> findByDiceCountAndDiceSides(final int diceCount, final int diceSides);
    
}
