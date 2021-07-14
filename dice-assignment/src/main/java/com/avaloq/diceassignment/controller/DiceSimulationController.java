package com.avaloq.diceassignment.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import com.avaloq.diceassignment.entity.DiceSimulationEntity;
import com.avaloq.diceassignment.entity.ResultsEntity;
import com.avaloq.diceassignment.exception.NoDataFoundExcetion;
import com.avaloq.diceassignment.repository.DiceSimulationRespository;
import com.avaloq.diceassignment.service.DiceSimulationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class DiceSimulationController {

    @Autowired
    private DiceSimulationService diceSimulationService;

    @Autowired
    private DiceSimulationRespository repository;

    // Below mentioned changes are related to assignment-1
    @RequestMapping(value = "/getDiceSimulation")
    public ResponseEntity<Object> getSimulationResult(@RequestParam(name = "dice_count") @Valid @Min(1) int diceCount,
    @RequestParam(name = "dice_sides") @Valid @Min(4) int diceSides,
    @RequestParam(name = "total_rolls") @Valid @Min(1) int totalRolls) {
       final Map<Integer, Integer> sumOccurrencesMap = diceSimulationService.getSimulationResult(diceCount, diceSides, totalRolls); 
       final  ResponseEntity<Object> response = new ResponseEntity<Object>(sumOccurrencesMap, HttpStatus.OK);
       final List<ResultsEntity> results = new ArrayList<ResultsEntity>(sumOccurrencesMap.size());
       final DiceSimulationEntity simulationEntity = new DiceSimulationEntity(diceCount, diceSides, totalRolls);
       sumOccurrencesMap.entrySet().forEach(entry -> {
        final ResultsEntity result = new ResultsEntity(entry.getKey(), entry.getValue());
        result.setDiceSimulationEntity(simulationEntity);
        results.add(result);
       });
       simulationEntity.setResults(results);
       repository.save(simulationEntity);
       return response;
    }

    // Changes for assignment-2 part1
    @RequestMapping(value = "/getTotalRollsWithSimulations")
    public ResponseEntity<Object> getTotalRollsWithSimulations() {
        return new ResponseEntity<Object>(repository.countTotalSimulationsByDiceNumbersAndSides(), HttpStatus.OK);
    }

    // Changes for assignment-2 part2
    @RequestMapping(value = "/getRelativeDistribution")
    public ResponseEntity<Object> getRelativeDistribution(@RequestParam(name = "dice_count") @Valid @Min(1) int diceCount,
    @RequestParam(name = "dice_sides") @Valid @Min(4) int diceSides) {
        final List<DiceSimulationEntity> simulationEntities = repository.findByDiceCountAndDiceSides(diceCount, diceSides);
        if(simulationEntities == null || simulationEntities.isEmpty()) {
            throw new NoDataFoundExcetion("No Data found for given dice number and dice side combination...");
        }
        return new ResponseEntity<Object>(diceSimulationService.getRelativeDistributions(simulationEntities), HttpStatus.OK);
    }

    
}