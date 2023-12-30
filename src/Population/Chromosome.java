package Population;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import Cities.Map;

public class Chromosome {
    private List<Integer> gene = new ArrayList<Integer>();
    public static int number_of_gen;

    public Chromosome(int number_of_cities) {
        number_of_gen = number_of_cities;

        for (int i = 1; i <= number_of_gen; i++) {
            gene.add(i);
        }
        Collections.shuffle(gene);
    }

    public Chromosome() {

    }

    public List<Integer> getGene() {
        return this.gene;
    }

    public void addGene(Integer add_gene) {
        gene.add(add_gene);
    }

    public Chromosome crossOver(Chromosome pair_mutantion) {
        Chromosome child = new Chromosome();
        Random random = new Random();

        for (int i = 0; i < random.nextInt(number_of_gen); i++) {
            child.addGene(pair_mutantion.getGene().get(i));
        }

        for (int i = 0; i < number_of_gen; i++) {
            if (!child.getGene().contains(gene.get(i))) {
                child.addGene(i);
            }
        }

        return child;
    }

    public Chromosome mutation() {
        Chromosome child = new Chromosome();
        Random random = new Random();

        int mutation_point = random.nextInt(1, number_of_gen - 1);

        for (int i = 0; i < number_of_gen; i++) {
            if (i == mutation_point - 1) {
                child.addGene(gene.get(mutation_point + 1));
            } else if (i == mutation_point + 1) {
                child.addGene(gene.get(mutation_point - 1));
            } else {
                child.addGene(gene.get(i));
            }
        }

        return child;
    }

    public int getValue(){
        int sum = 0;
        sum = sum + Map.getDistance(0, gene.get(0));

        for (int i = 0; i < number_of_gen - 1; i++) {
            sum = sum + Map.getDistance(gene.get(i), gene.get(i + 1));
        }

        sum = sum + Map.getDistance(gene.get(number_of_gen - 1), 0);
        
        return sum;
    }
    
}
