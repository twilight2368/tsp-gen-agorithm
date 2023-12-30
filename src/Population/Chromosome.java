package Population;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Chromosome {
    private List<Integer> gene = new ArrayList<Integer>();
    public static int number_of_gen;

    public Chromosome(int number_of_cities) {
        number_of_gen = number_of_cities;
        for (int i = 1; i <= number_of_cities; i++) {
            gene.add(i);
        }
        Collections.shuffle(gene);
    }

    public Chromosome() {

    }

    public List<Integer> getGene() {
        return this.gene;
    }

    public void addGene(Integer add_gene){
        gene.add(add_gene);
    }

    public Chromosome mutation(Chromosome pair_mutantion) {
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

    

}
