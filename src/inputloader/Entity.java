package inputloader;

import java.util.List;

public class Entity {

    private List<Consumer> consumers;
    private List<Distributor> distributors;
    private List<Producer> producers;

    public Entity() {

    }

    public Entity(final List<Consumer> consumers, final List<Distributor> distributors,
                  final List<Producer> producers) {
        this.consumers = consumers;
        this.distributors = distributors;
        this.producers = producers;
    }

    /***
     * intoarce consumatori
     * @return
     */
    public List<Consumer> getConsumers() {
        return consumers;
    }

    /***
     * seteaza consumatori
     * @param consumers
     */
    public void setConsumers(final List<Consumer> consumers) {
        this.consumers = consumers;
    }

    /***
     * intoarce distribuitori
     * @return
     */
    public List<Distributor> getDistributors() {
        return distributors;
    }

    /***
     * seteaza distribuitori
     * @param distributors
     */
    public void setDistributors(final List<Distributor> distributors) {
        this.distributors = distributors;
    }

    /***
     * intoarce lista de producatori
     * @return
     */
    public List<Producer> getProducers() {
        return producers;
    }

    /***
     * seteaza lista de producatori
     * @param producers
     */
    public void setProducers(List<Producer> producers) {
        this.producers = producers;
    }

    /***
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "Entity{"
                + "consumers=" + consumers
                + ", distributors=" + distributors
                + ", producers=" + producers
                + '}';
    }
}
