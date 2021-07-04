package inputloader;

import java.util.List;

public class Input {

    private String numberOfTurns;
    private Entity initialData;
    private List<MonthlyUpdates> monthlyUpdates;

    public Input(final String numberOfTurns, final Entity initialData,
                 final List<MonthlyUpdates> monthlyUpdates) {
        this.numberOfTurns = numberOfTurns;
        this.initialData = initialData;
        this.monthlyUpdates = monthlyUpdates;
    }

    public Input() {
        this.numberOfTurns = null;
        this.initialData = null;
        this.monthlyUpdates = null;
    }

    /***
     * intoarce numar de luni
     * @return
     */
    public String getNumberOfTurns() {
        return numberOfTurns;
    }

    /***
     * seteaza numar de luni
     * @param numberOfTurns
     */
    public void setNumberOfTurns(final String numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    /***
     * intoarce datele initiale
     * @return
     */
    public Entity getInitialData() {
        return initialData;
    }

    /***
     * seteaza datele initiale
     * @param initialData
     */
    public void setInitialData(final Entity initialData) {
        this.initialData = initialData;
    }

    /***
     * intoarce updateurile din toate lunile
     * @return
     */
    public List<MonthlyUpdates> getMonthlyUpdates() {
        return monthlyUpdates;
    }

    /***
     * seteaza updateurile din toate lunile
     * @param monthlyUpdates
     */
    public void setMonthlyUpdates(final List<MonthlyUpdates> monthlyUpdates) {
        this.monthlyUpdates = monthlyUpdates;
    }

    /***
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "inputloader.Input{"
                + "numberOfTurns='" + numberOfTurns + '\''
                + ", initialData=" + initialData
                + ", monthlyUpdates=" + monthlyUpdates
                + '}';
    }
}
