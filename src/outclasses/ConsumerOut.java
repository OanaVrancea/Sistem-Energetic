package outclasses;

public class ConsumerOut extends Common {

    private int id;
    private int initialBudget;
    private int monthlyIncome;
    private int finalBudget;
    private boolean isBankrupt;
    private int debt;
    private int delay;
    private DistributorOut distributorOut;
    private int debtForUnpayedMonth;
    private int contractMonthsRemained;

    public ConsumerOut() {

    }

    public ConsumerOut(final int id, final int initialBudget, final int monthlyIncome) {
        this.id = id;
        this.initialBudget = initialBudget;
        this.monthlyIncome = monthlyIncome;
        this.finalBudget = initialBudget;
        this.isBankrupt = false;
        this.debt = 0;
        this.delay = 0;
        this.debtForUnpayedMonth = 0;
        this.contractMonthsRemained = 0;
    }

    /***
     * intoarce id consumator
     * @return
     */
    public int getId() {
        return id;
    }

    /***
     * seteaza id consumator
     * @param id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /***
     * intoarce buget initial consumator
     * @return
     */
    public int getInitialBudget() {
        return initialBudget;
    }

    /***
     * seteaza buget initial consumator
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
     * intoarce buget final
     * @return
     */
    public int getFinalBudget() {
        return finalBudget;
    }

    /***
     * seteaza buget final
     * @param finalBudget
     */
    public void setFinalBudget(final int finalBudget) {
        this.finalBudget = finalBudget;
    }

    /***
     * intoarce daca consumatorul a falimentat sau nu
     * @return
     */
    public boolean isBankrupt() {
        return isBankrupt;
    }

    /***
     * seteaza daca consumatorul a falimentat sau nu
     * @param bankrupt
     */
    public void setBankrupt(final boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    /***
     * intoarce rata pe care o plateste consumatorul
     * @return
     */
    public int getDebt() {
        return debt;
    }

    /***
     * seteaza rata pe care o plateste consumatorul
     * @param debt
     */
    public void setDebt(final int debt) {
        this.debt = debt;
    }

    /***
     * intoarce daca consumatorul are o datorie sau nu
     * @return
     */
    public int getDelay() {
        return delay;
    }

    /***
     * seteaza daca consumatorul are o datorie sau nu
     * @param delay
     */
    public void setDelay(final int delay) {
        this.delay = delay;
    }

    /***
     * intoarce distribuitorul cu care are contract consumatorul
     * @return
     */
    public DistributorOut getDistributorOut() {
        return distributorOut;
    }

    /***
     * seteaza distribuitorul cu care are contract consumatorul
     * @param distributorOut
     */
    public void setDistributorOut(final DistributorOut distributorOut) {
        this.distributorOut = distributorOut;
    }

    /***
     * intoarce datoria consumatorului fata de distribuitor
     * @return
     */
    public int getDebtForUnpayedMonth() {
        return debtForUnpayedMonth;
    }

    /***
     * seteaza datoria consumatorului fata de distribuitor
     * @param debtForUnpayedMonth
     */
    public void setDebtForUnpayedMonth(final int debtForUnpayedMonth) {
        this.debtForUnpayedMonth = debtForUnpayedMonth;
    }

    /***
     * intoarce numarul de luni ramase in contract
     * @return
     */
    public int getContractMonthsRemained() {
        return contractMonthsRemained;
    }

    /***
     * seteaza numarul de luni ramase in contract
     * @param contractMonthsRemained
     */
    public void setContractMonthsRemained(final int contractMonthsRemained) {
        this.contractMonthsRemained = contractMonthsRemained;
    }

    /***
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "ConsumerOut{"
                + "id=" + id
                + ", initialBudget=" + initialBudget
                + ", monthlyIncome=" + monthlyIncome
                + ", isBankrupt=" + isBankrupt
                + ", finalBudget=" + finalBudget
                + ", debt=" + debt
                + ", delay=" + delay
                + ", debtForUnpayedMonth=" + debtForUnpayedMonth
                + ", contractMonthsRemained=" + contractMonthsRemained
                + '}';
    }
}
