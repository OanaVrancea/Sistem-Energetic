package inputloader;

public class DistributorChanges {
    private int id;
    private int infrastructureCost;

    public DistributorChanges() {

    }

    public DistributorChanges(int id, int infrastructureCost) {
        this.id = id;
        this.infrastructureCost = infrastructureCost;
    }

    /***
     * intoarce id ul distribuitorului care se modifica
     * @return
     */
    public int getId() {
        return id;
    }

    /***
     * seteaza id-ul distribuitorului care se modifica
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /***
     * intoarce noul pret pentru infrastructura
     * @return
     */
    public int getInfrastructureCost() {
        return infrastructureCost;
    }

    /***
     * seteaza noul pret pentru infrastructura
     * @param infrastructureCost
     */
    public void setInfrastructureCost(int infrastructureCost) {
        this.infrastructureCost = infrastructureCost;
    }

    /***
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "DistributorChanges{"
                + "id=" + id
                + ", infrastructureCost=" + infrastructureCost
                + '}';
    }
}
