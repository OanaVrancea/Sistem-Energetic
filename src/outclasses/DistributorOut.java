package outclasses;

import strategies.EnergyChoiceStrategyType;

import java.util.ArrayList;
import java.util.List;

public class DistributorOut extends Common {

    private int id;
    private int contractLength;
    private int initialBudget;
    private int initialInfrastructureCost;
    private int energyNeededKW;
    private EnergyChoiceStrategyType strategyType;
    private int finalBudget;
    private boolean isBankrupt;
    private int debt;
    private List<ConsumerOut> consumers = new ArrayList<ConsumerOut>();
    private List<ConsumerOut> previousMonthConsumer = new ArrayList<ConsumerOut>();
    private int consumersNumber;
    private int monthsRemained;
    private int lostClient;
    private int delayedClients;
    private int contractCost;
    private int productionCost;
    private Strategy strategy;
    private List<ProducerOut> producers = new ArrayList<>();
    private List<ProducerOut> allProducersSortedForSpecificDistributor
            = new ArrayList<>();

    public DistributorOut() {

    }

    public DistributorOut(final int id, final int contractLength,
                          final int initialBudget,
                          final int initialInfrastructureCost,
                          final int energyNeededKW,
                          final EnergyChoiceStrategyType strategyType) {
        this.id = id;
        this.contractLength = contractLength;
        this.initialBudget = initialBudget;
        this.initialInfrastructureCost = initialInfrastructureCost;
        this.energyNeededKW = energyNeededKW;
        this.strategyType = strategyType;
        this.finalBudget = initialBudget;
        this.isBankrupt = false;
        this.debt = 0;
        this.consumersNumber = 0;
        this.monthsRemained = contractLength;
        this.lostClient = 0;
        this.delayedClients = 0;
    }

    /***
     * intoarce lista cu toti producatorii sortati pentru distrubuitor
     * @return
     */
    public List<ProducerOut> getAllProducersSortedForSpecificDistributor() {
        return allProducersSortedForSpecificDistributor;
    }

    /***
     * seteaza lista cu toti producatorii sortati pentru distrubuitor
     * @param allProducersSortedForSpecificDistributor
     */
    public void setAllProducersSortedForSpecificDistributor(
            List<ProducerOut> allProducersSortedForSpecificDistributor) {
        this.allProducersSortedForSpecificDistributor =
                allProducersSortedForSpecificDistributor;
    }

    /***
     * intoarce strategia
     * @return
     */
    public Strategy getStrategy() {
        return strategy;
    }

    /***
     * seteaza strategia
     * @param strategy
     */
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /***
     * sorteaza producatorii dupa startegie si intoarce lista cu acestia sortati
     * @param producers1
     * @return
     */
    public List<ProducerOut> sortedProducers(List<ProducerOut> producers1) {
        if (this.getStrategyType().equals(EnergyChoiceStrategyType.GREEN)) {
            GreenStrategy greenStrategy = new GreenStrategy();
            return greenStrategy.selectBestProducers(producers1);
        }
        if (this.getStrategyType().equals(EnergyChoiceStrategyType.PRICE)) {
            PriceStrategy priceStrategy = new PriceStrategy();
            return priceStrategy.selectBestProducers(producers1);
        }
        if (this.getStrategyType().equals(EnergyChoiceStrategyType.QUANTITY)) {
            QuantityStrategy quantityStrategy = new QuantityStrategy();
            return quantityStrategy.selectBestProducers(producers1);
        }
        return null;
    }


    /***
     * intoarce id
     * @return
     */
    public int getId() {
        return id;
    }

    /***
     * seteaza id
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
     * intoarce cost infrastructura initial
     * @return
     */
    public int getInitialInfrastructureCost() {
        return initialInfrastructureCost;
    }

    /***
     * seteaza cost infrastructura initial
     * @param initialInfrastructureCost
     */
    public void setInitialInfrastructureCost(final int initialInfrastructureCost) {
        this.initialInfrastructureCost = initialInfrastructureCost;
    }

    /***
     * intoarce cantitatea de energie necesara
     * @return
     */
    public int getEnergyNeededKW() {
        return energyNeededKW;
    }

    /***
     * seteaza cantitatea de energie necesara
     * @param energyNeededKW
     */
    public void setEnergyNeededKW(int energyNeededKW) {
        this.energyNeededKW = energyNeededKW;
    }

    /***
     * intoarce tipul strategiei
     * @return
     */
    public EnergyChoiceStrategyType getStrategyType() {
        return strategyType;
    }

    /***
     * seteaza tipul strategiei
     * @param strategyType
     */
    public void setStrategyType(EnergyChoiceStrategyType strategyType) {
        this.strategyType = strategyType;
    }

    /***
     * intoarce buget final
     * @return
     */
    public int getFinalBudget() {
        return finalBudget;
    }

    /***
     * seteaza buget final
     * @param finalBudget
     */
    public void setFinalBudget(final int finalBudget) {
        this.finalBudget = finalBudget;
    }

    /***
     * intoarce daca este in faliment sau nu
     * @return
     */
    public boolean isBankrupt() {
        return isBankrupt;
    }

    /***
     * seteaza daca este in faliment sau nu
     * @param bankrupt
     */
    public void setBankrupt(final boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    /***
     * intoarce rata
     * @return
     */
    public int getDebt() {
        return debt;
    }

    /***
     * seteaza rata
     * @param debt
     */
    public void setDebt(final int debt) {
        this.debt = debt;
    }

    /***
     * intoarce lista de contracte
     * @return
     */
    public List<ConsumerOut> getConsumers() {
        return consumers;
    }

    /***
     * adaug consumator ca un contract al distrubuitorului
     * @param consumer
     */
    public void addConsumers(final ConsumerOut consumer) {
        this.getConsumers().add(this.getConsumers().size(), consumer);
    }

    /***
     * elimin contract
     * @param consumer
     */
    public void removeConsumers(final ConsumerOut consumer) {
        this.getConsumers().remove(consumer);
    }

    /***
     * seteaza lista de contracte
     * @param consumers
     */
    public void setConsumers(final List<ConsumerOut> consumers) {
        this.consumers = consumers;
    }

    /***
     * intoarce numar contracte
     * @return
     */
    public int getConsumersNumber() {
        return consumersNumber;
    }

    /***
     * seteaza numar contracte
     * @param consumersNumber
     */
    public void setConsumersNumber(final int consumersNumber) {
        this.consumersNumber = consumersNumber;
    }

    /***
     * intoarce numar luni ramese
     * @return
     */
    public int getMonthsRemained() {
        return monthsRemained;
    }

    /***
     * seteaza numar luni ramase
     * @param monthsRemained
     */
    public void setMonthsRemained(final int monthsRemained) {
        this.monthsRemained = monthsRemained;
    }

    /***
     * intoarce daca un client a falimentat sau nu
     * @return
     */
    public int getLostClient() {
        return lostClient;
    }

    /***
     * seteaza daca un client a falimentat sau nu
     * @param lostClient
     */
    public void setLostClient(final int lostClient) {
        this.lostClient = lostClient;
    }

    /***
     * intoarce clientii care au datorie
     * @return
     */
    public int getDelayedClients() {
        return delayedClients;
    }

    /***
     * intoarce clientii care au datorie
     * @param delayedClients
     */
    public void setDelayedClients(final int delayedClients) {
        this.delayedClients = delayedClients;
    }

    /***
     * intoarce contractele de luna trecuta
     * @return
     */
    public List<ConsumerOut> getPreviousMonthConsumer() {
        return previousMonthConsumer;
    }

    /***
     * seteaza contractele de luna trecuta
     * @param previousMonthConsumer
     */
    public void setPreviousMonthConsumer(final List<ConsumerOut> previousMonthConsumer) {
        this.previousMonthConsumer = previousMonthConsumer;
    }

    /***
     * intoarce costul unui contract ( datoria unui distribuitor)
     * @return
     */
    public int getContractCost() {
        return contractCost;
    }

    /***
     * seteaza costul unui contract
     * @param contractCost
     */
    public void setContractCost(int contractCost) {
        this.contractCost = contractCost;
    }

    /***
     * intoarce costul de productie obtinut
     * @return
     */
    public int getProductionCost() {
        return productionCost;
    }

    /***
     * seteaza costul de productie obtinut
     * @param productionCost
     */
    public void setProductionCost(int productionCost) {
        this.productionCost = productionCost;
    }

    /***
     * intoarce producatorii unui distribuitor
     * @return
     */
    public List<ProducerOut> getProducers() {
        return producers;
    }

    /***
     * seteaza producatorii unui distribuitor
     * @param producers
     */
    public void setProducers(List<ProducerOut> producers) {
        this.producers = producers;
    }

    /***
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "DistributorOut{"
                + "id=" + id
                + ", contractLength=" + contractLength
                + ", initialBudget=" + initialBudget
                + ", initialInfrastructureCost=" + initialInfrastructureCost
                + ", energyNeededKW=" + energyNeededKW
                + ", strategyType=" + strategyType
                + ", finalBudget=" + finalBudget
                + ", isBankrupt=" + isBankrupt
                + ", debt=" + debt
                + ", consumers=" + consumers
                + ", previousMonthConsumer=" + previousMonthConsumer
                + ", consumersNumber=" + consumersNumber
                + ", monthsRemained=" + monthsRemained
                + ", lostClient=" + lostClient
                + ", delayedClients=" + delayedClients
                + ", contractCost=" + contractCost
                + ", productionCost=" + productionCost
                + ", strategy=" + strategy
                + '}';
    }
}
