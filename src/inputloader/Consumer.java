package inputloader;

public class Consumer {

    private int id;
    private int initialBudget;
    private int monthlyIncome;

    public Consumer() {

    }

    public Consumer(final int id, final int initialBudget, final int monthlyIncome) {
        this.id = id;
        this.initialBudget = initialBudget;
        this.monthlyIncome = monthlyIncome;
    }

    /***
     * intoarce id consumer
     * @return
     */
    public int getId() {
        return id;
    }

    /***
     * seteaza id consumer
     * @param id
     */
    public void setId(final int id) {
        this.id = id;
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
     * intoarce venit lunar
     * @return
     */
    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    /***
     * seteaza venit lunar
     * @param monthlyIncome
     */
    public void setMonthlyIncome(final int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    /***
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "inputloader.Consumer{"
                + "id=" + id
                + ", initialBudget=" + initialBudget
                + ", monthlyIncome=" + monthlyIncome
                + '}';
    }
}
