public class Population {
    Individual[] individuals;

    /**
     * Constructors
     */
    public Population (int populationSize, boolean initialise) {
        individuals = new Individual[populationSize];
        // Initialise population
        if(initialise){
            // Loop and crate individuals
            for (int i = 0; i < size(); i++){
                Individual newIndividual = new Individual();
                newIndividual.generateIndividual();
                saveIndividual(i, newIndividual);
            }
        }

    }

    /**
     * Individual getIndividual
     * @param index
     * @return individuals[index]
     */
    public Individual getIndividual(int index) {
        return individuals[index];
    }

    /**
     * Individual getFittest
     * @return fittest
     */
    public Individual getFittest() {
        Individual fittest = individuals[0];
        for (int i = 0; i< size(); i++) {
            if (fittest.getFitness() <= getIndividual(i).getFitness()){
                fittest = getIndividual(i);
            }
        }
        return fittest;
    }

    /**
     * Integer size()
     * @return individuals.length
     *
     * Get population size
     */

    public int size() {
        return individuals.length;
    }

    public void saveIndividual(int index, Individual indiv) {
        individuals[index] = indiv;
    }

    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < size(); i++) {
            geneString += getIndividual(i).toString();
        }
        return geneString;
    }
}
