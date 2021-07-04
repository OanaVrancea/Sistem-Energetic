package outclasses;


import java.util.Comparator;
import java.util.List;

public class GreenStrategy implements Strategy {

    /***
     * selecteaza cei mai buni producatori
     * pentru distribuitorii care au tipul
     * strategiei GREEEN
     * @param producers
     * @return
     */
    @Override
    public List<ProducerOut> selectBestProducers(List<ProducerOut> producers) {
        producers.sort(new Comparator<ProducerOut>() {
            @Override
            public int compare(ProducerOut o1, ProducerOut o2) {
                //sortare in functie de proprietatea energiei de a fi renewable sau nu
                int compareEnergyType = Boolean.compare(o2.isRenewable(), o1.isRenewable());
                if (compareEnergyType == 0) {
                    //sortare in functie de pret
                    int compareByPrice = Float.compare(o1.getPriceKW(), o2.getPriceKW());
                    if (compareByPrice == 0) {
                        //sortare in functie de cantitate
                        return Integer.compare(o2.getEnergyPerDistributor(),
                                o1.getEnergyPerDistributor());
                    } else {
                        return compareByPrice;
                    }
                }
                return compareEnergyType;
            }
        });
        return producers;
    }

}


