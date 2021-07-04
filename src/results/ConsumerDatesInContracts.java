package results;

public class ConsumerDatesInContracts implements Comparable<ConsumerDatesInContracts> {
    private int consumerId;
    private int price;
    private int remainedContractMonths;

    public ConsumerDatesInContracts(final int consumerId, final int price,
                                    final int remainedContractMonths) {
        this.consumerId = consumerId;
        this.price = price;
        this.remainedContractMonths = remainedContractMonths;
    }

    /***
     * intoarce id client distribuitor
     * @return
     */
    public int getConsumerId() {
        return consumerId;
    }

    /***
     * seteaza id client distribuitor
     * @param consumerId
     */
    public void setConsumerId(final int consumerId) {
        this.consumerId = consumerId;
    }

    /***
     * intoarce rata client distribuitor
     * @return
     */
    public int getPrice() {
        return price;
    }

    /***
     * seteaza rata client distribuitor
     * @param price
     */
    public void setPrice(final int price) {
        this.price = price;
    }

    /***
     * intoarce luni ramase client distribuitor
     * @return
     */
    public int getRemainedContractMonths() {
        return remainedContractMonths;
    }

    /***
     * seteaza luni ramase client distribuitor
     * @param remainedContractMonths
     */
    public void setRemainedContractMonths(final int remainedContractMonths) {
        this.remainedContractMonths = remainedContractMonths;
    }

    /***
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "consumerId=" + consumerId
                + ", price=" + price
                + ", remainedContractMonths=" + remainedContractMonths
                + '}';
    }

    /***
     * compareTo
     * @param o
     * @return
     */
    @Override
    public int compareTo(final ConsumerDatesInContracts o) {
        return Integer.compare(this.getConsumerId(), o.getConsumerId());

    }
}
