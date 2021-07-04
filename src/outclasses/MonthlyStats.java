package outclasses;

import java.util.List;

public class MonthlyStats {
    private int month;
    private List<Integer> distributorsIds;

    public MonthlyStats(int month, List<Integer> distributorsIds) {
        this.month = month;
        this.distributorsIds = distributorsIds;
    }

    /***
     * intorce numarul lunii corespunzatoare
     * @return
     */
    public int getMonth() {
        return month;
    }

    /***
     * seteaza numarul lunii corespunzatoare
     * @param month1
     */
    public void setMonthNumber(int month1) {
        this.month = month1;
    }

    /***
     * intoarce id-urile distribuitorilor care apartin unui
     * producator in luna respectiva
     * @return
     */
    public List<Integer> getDistributorsIds() {
        return distributorsIds;
    }

    /***
     * intoarce id-urile distribuitorilor care apartin unui
     * producator in luna respectiva
     * @param distributorsIds
     */
    public void setDistributorsIds(List<Integer> distributorsIds) {
        this.distributorsIds = distributorsIds;
    }

    /***
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "MonthlyStats{"
                + "month=" + month
                + ", distributorsIds=" + distributorsIds
                + '}';
    }
}
