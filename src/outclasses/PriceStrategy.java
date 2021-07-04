package outclasses;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PriceStrategy implements Strategy {
    /***
     * selecteaza cei mai buni producatori
     * pentru distribuitorii care au tipul
     * strategiei PRICE
     * @param producers
     * @return
     */
    @Override
    public List<ProducerOut> selectBestProducers(List<ProducerOut> producers) {
        Collections.sort(producers, new Comparator<ProducerOut>() {
            @Override
            public int compare(ProducerOut o1, ProducerOut o2) {
                //sortare in functie de pret
                int compareByPrice = Float.compare(o1.getPriceKW(), o2.getPriceKW());
                if (compareByPrice == 0) {
                    //sortare in functie de cantitate
                    return Integer
                            .compare(o2.getEnergyPerDistributor(), o1.getEnergyPerDistributor());
                } else {
                    return compareByPrice;
                }
            }
        });
        return producers;
    }
}
