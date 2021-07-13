package com.avaloq.diceassignment.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class DiceSimulationController {

    @RequestMapping(value = "/getDiceSimulation")
    public String getSimulationResult(@RequestParam(name = "dice_count") @Valid @Min(1) int diceCount,
    @RequestParam(name = "dice_sides") @Valid @Min(4) int diceSides,
    @RequestParam(name = "total_rolls") @Valid @Min(1) int totalRolls) {
        return "Hello!!!" + diceCount;
    }
}