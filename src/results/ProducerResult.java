package results;

import entities.EnergyType;
import outclasses.MonthlyStats;

import java.util.List;

public class ProducerResult {
    private int id;
    private int maxDistributors;
    private float priceKW;
    private EnergyType energyType;
    private int energyPerDistributor;
    private List<MonthlyStats> monthlyStats;

    public ProducerResult(int id, int maxDistributors, float priceKW, EnergyType energyType,
                          int energyPerDistributor, List<MonthlyStats> monthlyStats) {
        this.id = id;
        this.maxDistributors = maxDistributors;
        this.priceKW = priceKW;
        this.energyType = energyType;
        this.energyPerDistributor = energyPerDistributor;
        this.monthlyStats = monthlyStats;
    }

    /***
     * intoarce id-ul unui producator
     * @return
     */
    public int getId() {
        return id;
    }

    /***
     * seteaza id-ul unui producator
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /***
     * intoarce numar maxim distribuitori
     * @return
     */
    public int getMaxDistributors() {
        return maxDistributors;
    }

    /***
     * seteaza numar maxim distribuitori
     * @param maxDistributors
     */
    public void setMaxDistributors(int maxDistributors) {
        this.maxDistributors = maxDistributors;
    }

    /***
     * intoarce pretul pentru energie
     * @return
     */
    public float getPriceKW() {
        return priceKW;
    }

    /***
     * seteaza pretul pentru energie
     * @param priceKW
     */
    public void setPriceKW(float priceKW) {
        this.priceKW = priceKW;
    }

    /***
     * intoarce tipul de energie
     * @return
     */
    public EnergyType getEnergyType() {
        return energyType;
    }

    /***
     * seteaza tipul de energie
     * @param energyType
     */
    public void setEnergyType(EnergyType energyType) {
        this.energyType = energyType;
    }

    /***
     * intoarce cantitatea de energie acordata unui distribuitor
     * @return
     */
    public int getEnergyPerDistributor() {
        return energyPerDistributor;
    }

    /***
     * seteaza cantitatea de energie acordata unui distribuitor
     * @param energyPerDistributor
     */
    public void setEnergyPerDistributor(int energyPerDistributor) {
        this.energyPerDistributor = energyPerDistributor;
    }

    /***
     * intoarce lista cu luni si distribuitorii corespunzatori
     * @return
     */
    public List<MonthlyStats> getMonthlyStats() {
        return monthlyStats;
    }

    /***
     * seteaza lista cu luni si distribuitorii corespunzatori
     * @param monthlyStats
     */
    public void setMonthlyStats(List<MonthlyStats> monthlyStats) {
        this.monthlyStats = monthlyStats;
    }

    /***
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "id=" + id
                + ", maxDistributors=" + maxDistributors
                + ", priceKW=" + priceKW
                + ", energyType=" + energyType
                + ", energyPerDistributor=" + energyPerDistributor
                + ", monthlyStats=" + monthlyStats
                + '}';
    }
}
