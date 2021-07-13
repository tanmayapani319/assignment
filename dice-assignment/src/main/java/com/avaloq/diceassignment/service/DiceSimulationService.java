package com.avaloq.diceassignment.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.avaloq.diceassignment.model.DiceBuilder;
import com.avaloq.diceassignment.model.Dice;

import org.springframework.stereotype.Service;

@Service
public class DiceSimulationService {

    public static final Random GENERATOR = new Random();
    
    public Map<Integer, Integer> getSimulationResult(final int diceCount, final int sides, final int totalRolls) {
        final List<Dice> dices = new ArrayList<>();
        final Map<Integer, Integer> totalSumMap = new HashMap<>(); 
        for(int count=0; count < diceCount; count++) {
            dices.add(getDice(sides));
        }

        // Iterate over the number of rolls and calculate total
        for(int roll=0; roll < totalRolls; roll++) {
            final int total_sum = dices.stream()
            .map(dice -> performRollOperation(dice))
            .reduce(0, Integer::sum);

            if(!totalSumMap.containsKey(total_sum)) {
                totalSumMap.put(total_sum, 1);
            } else {
                totalSumMap.put(total_sum, totalSumMap.get(total_sum) + 1);
            }
        }
        return totalSumMap;
    }

    private Dice getDice(final int sides) {
        return new DiceBuilder().withSides(sides).build();
    }

    private int performRollOperation(final Dice dice) {
        return 1 + DiceSimulationService.GENERATOR.nextInt(dice.getSides());
    }
}
