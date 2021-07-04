package results;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "bankrupt", "budget"})
public class ConsumerResult {
    private int id;
    private boolean isBankrupt;
    private int budget;

    public ConsumerResult(final int id, final boolean isBankrupt, final int budget) {
        this.id = id;
        this.isBankrupt = isBankrupt;
        this.budget = budget;
    }

    /***
     * intoarce consumator id
     * @return
     */
    public int getId() {
        return id;
    }

    /***
     * seteaza consumator id
     * @param id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /***
     * intoarce daca consumatorul a dat faliment sau nu
     * @return
     */
    @JsonGetter("isBankrupt")
    public boolean isBankrupt() {
        return isBankrupt;
    }

    /***
     * seteaza daca consumatorul a dat faliment sau nu
     * @param bankrupt
     */
    public void setBankrupt(final boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    /***
     * intoarce buget consumator
     * @return
     */
    public int getBudget() {
        return budget;
    }

    /***
     * seteaza buget consumator
     * @param budget
     */
    public void setBudget(final int budget) {
        this.budget = budget;
    }

    /***
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "id=" + id
                + ", isBankrupt=" + isBankrupt
                + ", budget=" + budget
                + '}';
    }
}
