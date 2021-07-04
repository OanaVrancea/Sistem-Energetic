package outclasses;

import entities.EnergyType;

import java.util.ArrayList;
import java.util.List;

public class ProducerOut {
    private int id;
    private int maxDistributors;
    private float priceKW;
    private EnergyType energyType;
    private boolean isRenewable;
    private int energyPerDistributor;
    private List<MonthlyStats> monthlyStats = new ArrayList<>();
    private List<DistributorOut> distributorOfProducer = new ArrayList<>();

    public ProducerOut() {
    }

    public ProducerOut(int id, int maxDistributors, float priceKW,
                       EnergyType energyType, int energyPerDistributor) {
        this.id = id;
        this.maxDistributors = maxDistributors;
        this.priceKW = priceKW;
        this.energyType = energyType;
        this.energyPerDistributor = energyPerDistributor;
        this.isRenewable = energyType.isRenewable();

    }

    /***
     * intoarce lista cu distribuitorii producatorului
     * @return
     */
    public List<DistributorOut> getDistributorOfProducer() {
        return distributorOfProducer;
    }

    /***
     * seteaza lista cu distribuitorii producatorului
     * @return
     */
    public void setDistributorOfProducer(List<DistributorOut> distributorOfProducer) {
        this.distributorOfProducer = distributorOfProducer;
    }

    /***
     * intoarce daca tipul de energie este regenerabil sau nu
     * @return
     */
    public boolean isRenewable() {
        return isRenewable;
    }

    /***
     * seteaza daca tipul de energie este regenerabil sau nu
     * @param renewable
     */
    public void setRenewable(boolean renewable) {
        isRenewable = renewable;
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
     * intoarce numar maxim distribuitori pe care poate sa ii aiba
     * @return
     */
    public int getMaxDistributors() {
        return maxDistributors;
    }

    /***
     * seteaza numar maxim distribuitori pe care poate sa ii aiba
     * @param maxDistributors
     */
    public void setMaxDistributors(int maxDistributors) {
        this.maxDistributors = maxDistributors;
    }

    /***
     * intoarce pretul
     * @return
     */
    public float getPriceKW() {
        return priceKW;
    }

    /***
     * seteaza pretul
     * @param priceKW
     */
    public void setPriceKW(float priceKW) {
        this.priceKW = priceKW;
    }

    /**
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
     * intoarce cantitatea de energie pe care o poate oferi unui singur
     * distribuitor
     * @return
     */
    public int getEnergyPerDistributor() {
        return energyPerDistributor;
    }

    /***
     * seteaza cantitatea de energie pe care o poate oferi unui singur
     * distribuitor
     * @param energyPerDistributor
     */
    public void setEnergyPerDistributor(int energyPerDistributor) {
        this.energyPerDistributor = energyPerDistributor;
    }

    /***
     * intoarce lista cu numarul de distribuitori pe care i-a avut
     * producatorul intr-o luna
     * @return
     */
    public List<MonthlyStats> getMonthlyStats() {
        return monthlyStats;
    }
    /***
     * seteaza lista cu numarul de distribuitori pe care i-a avut
     * producatorul intr-o luna
     * @return
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
        return "ProducerOut{"
                + "id=" + id
                + ", maxDistributors=" + maxDistributors
                + ", priceKW=" + priceKW
                + ", energyType=" + energyType
                + ", isRenewable=" + isRenewable
                + ", energyPerDistributor=" + energyPerDistributor
                + ", monthlyStats=" + monthlyStats
                + ", distributorOfProducer=" + distributorOfProducer
                + '}';
    }
}
