package Population;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Population {
    private List<Chromosome> population = new ArrayList<>();
    private int number_of_population;

    public Population(int number_of_population, int number_of_cities) {
        this.number_of_population = number_of_population;
        for (int i = 0; i < number_of_population; i++) {
            Chromosome chromosome = new Chromosome(number_of_cities);
            population.add(chromosome);
        }
    }

    public int getNumberOfpopulation() {
        return this.number_of_population;
    }

    public List<Chromosome> getPopulation() {
        return this.population;
    }

    public Chromosome getOneRandomParent(){
        Random random = new Random();

        int parent = random.nextInt(number_of_population);

        return population.get(parent);
    }

    

}
