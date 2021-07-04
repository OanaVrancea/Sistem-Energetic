package inputloader;

import java.util.List;

public class MonthlyUpdates {

    private List<Consumer> newConsumers;
    private List<DistributorChanges> distributorChanges;
    private List<ProducerChanges> producerChanges;

    public MonthlyUpdates() {

    }

    public MonthlyUpdates(final List<Consumer> newConsumers,
                          final List<DistributorChanges> distributorChanges,
                          final List<ProducerChanges> producerChanges) {
        this.newConsumers = newConsumers;
        this.distributorChanges = distributorChanges;
        this.producerChanges = producerChanges;
    }

    /***
     * intoarce lista de noi consumatori
     * @return
     */
    public List<Consumer> getNewConsumers() {
        return newConsumers;
    }

    /***
     * seteaza lista de noi consumatori
     * @param newConsumers
     */
    public void setNewConsumers(final List<Consumer> newConsumers) {
        this.newConsumers = newConsumers;
    }

    /***
     * intoarce lista de distribuitori care sufera modificari
     * @return
     */
    public List<DistributorChanges> getDistributorChanges() {
        return distributorChanges;
    }

    /***
     * seteaza lista de distribuitori care sufera modificari
     * @param distributorChanges
     */
    public void setDistributorChanges(List<DistributorChanges> distributorChanges) {
        this.distributorChanges = distributorChanges;
    }

    /***
     * intoarce lista de producatori care sufera modificari
     * @return
     */
    public List<ProducerChanges> getProducerChanges() {
        return producerChanges;
    }

    /***
     * seteaza lista de producatori care sufera modificari
     * @param producerChanges
     */
    public void setProducerChanges(List<ProducerChanges> producerChanges) {
        this.producerChanges = producerChanges;
    }

    /***
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "MonthlyUpdates{"
                + "newConsumers=" + newConsumers
                + ", distributorChanges=" + distributorChanges
                + ", producerChanges=" + producerChanges
                + '}';
    }
}
