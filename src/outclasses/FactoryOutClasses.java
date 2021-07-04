package outclasses;

import strategies.EnergyChoiceStrategyType;

public final class FactoryOutClasses {
    private FactoryOutClasses() {
    }

    private static FactoryOutClasses instance = null;

    /***
     * metoda care instantiaza un singur obiect
     * implementarea pt Singleton Pattern
     * @return
     */
    public static FactoryOutClasses getInstance() {
        if (instance == null) {
            instance = new FactoryOutClasses();
        }
        return instance;
    }

    /***
     * metoda care imi construieste o entitate
     * este implementarea pt Factory Pattern
     * @param entity
     * @param id
     * @param initialBudget
     * @param monthlyIncome
     * @param contractLength
     * @param initialInfrastructureCost
     * @return
     */
    public static Common createEntity(final Common entity, final int id,
                                      final int initialBudget, final int monthlyIncome,
                                      final int contractLength, final int initialInfrastructureCost,
                                      final int energyNeededKW,
                                      final EnergyChoiceStrategyType strategyType) {
        if (entity instanceof ConsumerOut) {
            return new ConsumerOut(id, initialBudget, monthlyIncome);
        }
        if (entity instanceof DistributorOut) {
            return new DistributorOut(id, contractLength, initialBudget, initialInfrastructureCost,
                    energyNeededKW, strategyType);
        }
        return null;
    }
}
