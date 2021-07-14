# assignment
- Have made use of javax validation framework for bean validation like dice numbers, dice sides total rolls etc
- Used h2 in-memory database for storing results
- For exception handling I have used an interceptor to handle specific exceptions arising in controller
- For handling database interaction, I have made use for DiceSimulationRepository which contains metods for DB interactions
- For returning response as JSON, I have used ResponseEntity

# Assignment-1 specific details
- For dice distribution simulation, I have created Dice model and its corresponding builder class
- For simulating dice roll, the changes are present in service class
  - For this, I have used RandomNumber and kept the bound same as dice sides.
  - The number returned is 1 + nextInt, because nextInt considers 0 while returning. But 0 can not be value of any dice side
- The simulation results are persisted in h2 database so as to reuse the results during assignment-2
- I have created 2 entities, one for dice simulation and one for storing the total sum and its occurrences
- In one simulation, we can have multiple sum results and their occurrences. Hence for DiceSimulationEntity, I have used @OneToMany and in ResultsEntity I have used @ManyToOne annotations to support bidirectional mapping

# Assignment-2 specific details
- For assignment-2 part-1, I have prepared JPA query to group by based on dice numbers and dice counts and used  projection to map data while retrieving from DB
- For assignment-2 part-2, first I retrieve the entries from database based on input dice numbers and dice sides. Then
with the results, I delegate call to service class to calculate relative distribution for sum of dice values with respect to total roll.