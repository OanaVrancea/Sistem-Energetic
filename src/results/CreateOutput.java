package results;

import java.util.List;

public class CreateOutput {
    private List<ConsumerResult> consumers;
    private List<DistributorResult> distributors;
    private List<ProducerResult> producers;

    public CreateOutput(final List<ConsumerResult> consumers,
                        final List<DistributorResult> distributors,
                        final List<ProducerResult> producers) {
        this.consumers = consumers;
        this.distributors = distributors;
        this.producers = producers;
    }

    /***
     * intoarce lista consumatori
     * @return
     */
    public List<ConsumerResult> getConsumers() {
        return consumers;
    }

    /***
     * seteaza lista consumatori
     * @param consumers
     */
    public void setConsumers(final List<ConsumerResult> consumers) {
        this.consumers = consumers;
    }

    /***
     * intoarce lista distribuitori
     * @return
     */
    public List<DistributorResult> getDistributors() {
        return distributors;
    }

    /***
     * seteaza lista distribuitori
     * @param distributors
     */
    public void setDistributors(final List<DistributorResult> distributors) {
        this.distributors = distributors;
    }

    /***
     * intoarce lista producatori
     * @return
     */
    public List<ProducerResult> getEnergyProducers() {
        return producers;
    }

    /***
     * seteaza lista producatori
     * @param producers
     */
    public void setProducers(List<ProducerResult> producers) {
        this.producers = producers;
    }

    /***
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "CreateOutput{"
                + "consumers=" + consumers
                + ", distributors=" + distributors
                + ", energyProducers =" + producers
                + '}';
    }
}
