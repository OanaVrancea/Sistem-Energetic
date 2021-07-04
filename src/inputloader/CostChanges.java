package inputloader;

public class CostChanges {

    private int id;
    private int infrastructureCost;
    private int productionCost;

    public CostChanges() {

    }

    public CostChanges(final int id, final int infrastructureCost, final int productionCost) {
        this.id = id;
        this.infrastructureCost = infrastructureCost;
        this.productionCost = productionCost;
    }

    /***
     * intoarce id
     * @return
     */
    public int getid() {
        return id;
    }

    /***
     * seteaza id
     * @param id1
     */
    public void setid(final int id1) {
        this.id = id1;
    }

    /***
     * intoarce nou cost infrastructura
     * @return
     */
    public int getInfrastructureCost() {
        return infrastructureCost;
    }

    /***
     * seteaza nou cost infrastructura
     * @param infrastructureCost
     */
    public void setInfrastructureCost(final int infrastructureCost) {
        this.infrastructureCost = infrastructureCost;
    }

    /***
     * intoarce nou cost productie
     * @return
     */
    public int getProductionCost() {
        return productionCost;
    }

    /***
     * seteaza nou cost productie
     * @param productionCost
     */
    public void setProductionCost(final int productionCost) {
        this.productionCost = productionCost;
    }

    /***
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "inputloader.CostChanges{"
                + "id=" + id
                + ", infrastructureCost=" + infrastructureCost
                + ", productionCost=" + productionCost
                + '}';
    }
}
