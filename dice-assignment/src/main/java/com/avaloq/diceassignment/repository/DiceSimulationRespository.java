package com.avaloq.diceassignment.repository;

import com.avaloq.diceassignment.entity.DiceSimulationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiceSimulationRespository extends JpaRepository<DiceSimulationEntity, Long>{
    
}
