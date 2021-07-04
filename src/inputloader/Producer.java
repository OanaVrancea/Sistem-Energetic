package inputloader;

import entities.EnergyType;

public class Producer {
    private int id;
    private EnergyType energyType;
    private int maxDistributors;
    private float priceKW;
    private int energyPerDistributor;

    public Producer() {

    }

    public Producer(int id, EnergyType energyType, int maxDistributors, float priceKW,
                    int energyPerDistributor) {
        this.id = id;
        this.energyType = energyType;
        this.maxDistributors = maxDistributors;
        this.priceKW = priceKW;
        this.energyPerDistributor = energyPerDistributor;
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
     * intoarce tipul de energie al unui producator
     * @return
     */
    public EnergyType getEnergyType() {
        return energyType;
    }

    /***
     * seteaza tipul de energie al unui producator
     * @param energyType
     */
    public void setEnergyType(EnergyType energyType) {
        this.energyType = energyType;
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
     * intoarce pretul unui producator
     * @return
     */
    public float getPriceKW() {
        return priceKW;
    }

    /***
     * seteaza pretul unui producator
     * @param priceKW
     */
    public void setPriceKW(float priceKW) {
        this.priceKW = priceKW;
    }

    /***
     * intoarce cantitatea de energie acordata unui distribuitor
     * @return
     */
    public int getEnergyPerDistributor() {
        return energyPerDistributor;
    }

    /****
     * seteaza cantitatea de energie acordata unui distribuitor
     * @param energyPerDistributor
     */
    public void setEnergyPerDistributor(int energyPerDistributor) {
        this.energyPerDistributor = energyPerDistributor;
    }

    /***
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "Producer{"
                + "id=" + id
                + ", energyType='" + energyType + '\''
                + ", maxDistributors=" + maxDistributors
                + ", priceKW=" + priceKW
                + ", energyPerDistributor=" + energyPerDistributor
                + '}';
    }
}
