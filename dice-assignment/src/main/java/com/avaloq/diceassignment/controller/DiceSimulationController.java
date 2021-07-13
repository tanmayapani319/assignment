package com.avaloq.diceassignment.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import com.avaloq.diceassignment.entity.DiceSimulationEntity;
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

    @RequestMapping(value = "/getDiceSimulation")
    public ResponseEntity<Object> getSimulationResult(@RequestParam(name = "dice_count") @Valid @Min(1) int diceCount,
    @RequestParam(name = "dice_sides") @Valid @Min(4) int diceSides,
    @RequestParam(name = "total_rolls") @Valid @Min(1) int totalRolls) {
       final  ResponseEntity<Object> response = new ResponseEntity<Object>(diceSimulationService.getSimulationResult(diceCount, diceSides, totalRolls), HttpStatus.OK);
       repository.save(new DiceSimulationEntity(diceCount, diceSides, totalRolls));
       return response;
    }
}