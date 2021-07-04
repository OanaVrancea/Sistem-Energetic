package results;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import strategies.EnergyChoiceStrategyType;

import java.util.List;

@JsonPropertyOrder({"id", "energyNeededKW", "contractCost", "budget",
        "producerStrategy", "bankrupt", "contracts"})
public class DistributorResult {
    private int id;
    private int energyNeededKW;
    private int contractCost;
    private int budget;
    private EnergyChoiceStrategyType producerStrategy;
    private boolean isBankrupt;
    private List<ConsumerDatesInContracts> contracts;

    public DistributorResult(int id, int energyNeededKW, int contractCost, int budget,
                             EnergyChoiceStrategyType producerStrategy, boolean isBankrupt,
                             List<ConsumerDatesInContracts> contracts) {
        this.id = id;
        this.energyNeededKW = energyNeededKW;
        this.contractCost = contractCost;
        this.budget = budget;
        this.producerStrategy = producerStrategy;
        this.isBankrupt = isBankrupt;
        this.contracts = contracts;
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
     * intoarce pretul unui contract
     * @return
     */
    public int getContractCost() {
        return contractCost;
    }

    /***
     * seteaza pretul unui contract
     * @param contractCost
     */
    public void setContractCost(int contractCost) {
        this.contractCost = contractCost;
    }

    /***
     * intoarce strategia dupa care isi alege un producator
     * @return
     */
    public EnergyChoiceStrategyType getProducerStrategy() {
        return producerStrategy;
    }

    /***
     * seteaza strategia dupa care isi alege un producator
     * @param producerStrategy
     */
    public void setProducerStrategy(EnergyChoiceStrategyType producerStrategy) {
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
     * intoarce buget distribuitor
     * @return
     */
    public int getBudget() {
        return budget;
    }

    /***
     * seteaza buget distribuitor
     * @param budget
     */
    public void setBudget(final int budget) {
        this.budget = budget;
    }

    /***
     * setez daca distribuitorul a falimentat sau nu
     * @return
     */
    @JsonGetter("isBankrupt")
    public boolean isBankrupt() {
        return isBankrupt;
    }

    /***
     * seteaza daca distribuitorul a dat faliment sau n
     * @param bankrupt
     */
    public void setBankrupt(final boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    /***
     * intoarce contracte distribuitor
     * @return
     */
    public List<ConsumerDatesInContracts> getContracts() {
        return contracts;
    }

    /***
     * seteaza contracte distribuitor
     * @param contractsList
     */
    public void setContracts(final List<ConsumerDatesInContracts> contractsList) {
        this.contracts = contractsList;
    }

    /***
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "id=" + id
                + ", budget=" + budget
                + ", isBankrupt=" + isBankrupt
                + ", contracts=" + contracts
                + '}';
    }
}
