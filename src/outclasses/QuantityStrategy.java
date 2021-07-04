package outclasses;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class QuantityStrategy implements Strategy {
    /***
     *  selecteaza cei mai buni producatori
     *  pentru distribuitorii care au tipul
     *  strategiei QUANTITY
     */
    @Override
    public List<ProducerOut> selectBestProducers(List<ProducerOut> producers) {
        Collections.sort(producers, new Comparator<ProducerOut>() {
            @Override
            public int compare(ProducerOut o1, ProducerOut o2) {
                //sortare in functie de cantitate de energie
               int compareByQuantity = Integer.compare(
                       o2.getEnergyPerDistributor(), o1.getEnergyPerDistributor());
                return compareByQuantity;
            }
        });
        return producers;
    }
}
