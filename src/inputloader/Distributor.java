package inputloader;

import strategies.EnergyChoiceStrategyType;

public class Distributor {

    private int id;
    private int contractLength;
    private int initialBudget;
    private int initialInfrastructureCost;
    private int energyNeededKW;
    private EnergyChoiceStrategyType producerStrategy;

    public Distributor() {

    }

    public Distributor(int id, int contractLength, int initialBudget, int initialInfrastructureCost,
                       int energyNeededKW, EnergyChoiceStrategyType producerStrategy) {
        this.id = id;
        this.contractLength = contractLength;
        this.initialBudget = initialBudget;
        this.initialInfrastructureCost = initialInfrastructureCost;
        this.energyNeededKW = energyNeededKW;
        this.producerStrategy = producerStrategy;
    }


    /***
     * intoarce id distribuitor
     * @return
     */
    public int getId() {
        return id;
    }

    /***
     * seteaza id distribuitor
     * @param id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /***
     * intoarce lungime contract
     * @return
     */
    public int getContractLength() {
        return contractLength;
    }

    /***
     * seteaza lungime contract
     * @param contractLength
     */
    public void setContractLength(final int contractLength) {
        this.contractLength = contractLength;
    }

    /***
     * intoarce buget initial
     * @return
     */
    public int getInitialBudget() {
        return initialBudget;
    }

    /***
     * seteaza buget initial
     * @param initialBudget
     */
    public void setInitialBudget(final int initialBudget) {
        this.initialBudget = initialBudget;
    }

    /***
     * intoarce cost initial infrastructura
     * @return
     */
    public int getInitialInfrastructureCost() {
        return initialInfrastructureCost;
    }

    /***
     * seteaza cost initial infrastructura
     * @param initialInfrastructureCost
     */
    public void setInitialInfrastructureCost(final int initialInfrastructureCost) {
        this.initialInfrastructureCost = initialInfrastructureCost;
    }

    /***
     * intoarce energia necesara unui distrubuitor
     * @return
     */
    public int getEnergyNeededKW() {
        return energyNeededKW;
    }

    /***
     * seteaza energia necesara
     * @param energyNeededKW
     */
    public void setEnergyNeededKW(int energyNeededKW) {
        this.energyNeededKW = energyNeededKW;
    }

    /***
     * intoarce strategia dupa care isi alege un producator sau mai multi
     * @return
     */
    public EnergyChoiceStrategyType getProducerStrategy() {
        return producerStrategy;
    }

    /***
     * seteaza strategia
     * @param producerStrategy
     */
    public void setProducerStrategy(EnergyChoiceStrategyType producerStrategy) {
        this.producerStrategy = producerStrategy;
    }

    /***
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "Distributor{"
                + "id=" + id
                + ", contractLength=" + contractLength
                + ", initialBudget=" + initialBudget
                + ", initialInfrastructureCost=" + initialInfrastructureCost
                + ", energyNeededKW=" + energyNeededKW
                + ", producerStrategy=" + producerStrategy
                + '}';
    }
}





