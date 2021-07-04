package inputloader;

public class ProducerChanges {
    private int id;
    private int energyPerDistributor;

    public ProducerChanges() {

    }

    public ProducerChanges(int id, int energyPerDistributor) {
        this.id = id;
        this.energyPerDistributor = energyPerDistributor;
    }

    /***
     * intoarce id-ul producatorului care a fost modificat
     * @return
     */
    public int getId() {
        return id;
    }

    /***
     * seteaza id-ul producatorului care a fost modificat
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /***
     * intoarce noua cantitate de energie pe care producatorul o acorda unui distribuitor
     * @return
     */
    public int getEnergyPerDistributor() {
        return energyPerDistributor;
    }

    /***
     * seteaza noua cantitate de energie pe care producatorul o acorda unui distribuitor
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
        return "ProducerChanges{"
                + "id=" + id
                + ", energyPerDistributor=" + energyPerDistributor
                + '}';
    }
}
